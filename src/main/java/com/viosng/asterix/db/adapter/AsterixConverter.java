package com.viosng.asterix.db.adapter;

import com.google.common.base.Joiner;
import com.viosng.asterix.db.adapter.thrift.ThriftExpression;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 28.03.2015
 * Time: 17:58
 */
public class AsterixConverter {

    private static final AtomicLong VARIABLE_COUNTER = new AtomicLong();

    private static String nextVar(){
        return "var" + VARIABLE_COUNTER.getAndIncrement();
    }

    private static String convertBinaryExp(ThriftExpression exp, String operator, String variable) {
        return "(" + convert(exp.getArguments().get(0), variable) + " " + operator +
                " " + convert(exp.getArguments().get(1), variable) + ")";
    }

    public static String convert(ThriftExpression exp) {
        return "use dataverse AsterixTest; " + convert(exp, "");
    }

    private static String convert(ThriftExpression exp, String variable) {
        switch (exp.type) {
            case AND:
                return convertBinaryExp(exp, "and", variable);
            case OR:
                return convertBinaryExp(exp, "or", variable);
            case PLUS:
                return convertBinaryExp(exp, "+", variable);
            case MINUS:
                return convertBinaryExp(exp, "-", variable);
            case MULTIPLY:
                return convertBinaryExp(exp, "*", variable);
            case DIVIDE:
                return convertBinaryExp(exp, "/", variable);
            case MODULAR:
                return convertBinaryExp(exp, "%", variable);
            case POWER:
                return convertBinaryExp(exp, "^", variable);
            case EQUAL:
                return convertBinaryExp(exp, "=", variable);
            case GT:
                return convertBinaryExp(exp, ">", variable);
            case LT:
                return convertBinaryExp(exp, "<", variable);
            case GE:
                return convertBinaryExp(exp, ">=", variable);
            case LE:
                return convertBinaryExp(exp, "<=", variable);
            case NOT_EQUAL:
                return convertBinaryExp(exp, "!=", variable);
            case NOT:
                return "not " + convert(exp.getArguments().get(0), variable);
            case CONCATENATION:
                return convertBinaryExp(exp, "+", variable);
            case FUNCTION_CALL:
                return exp.getValue() + "(" + Joiner.on(", ").join(exp.getArguments().stream()
                        .map(a -> convert(a, variable)).collect(Collectors.toList())) + ")";
            case CONSTANT:
                return exp.getValue().equalsIgnoreCase("true") || exp.getValue().equalsIgnoreCase("false")
                        ? exp.getValue().toLowerCase()
                        : (isNumeric(exp.getValue())
                        ? exp.getValue()
                        : "\"" + exp.getValue() + "\""
                        );
            case ATTRIBUTE:
                return "$" + variable + "." + exp.getValue();
            case QUERY:
                switch (exp.getQueryType()) {
                    case PRIMARY: {
                        String sourceName = convert(exp.getParameters().stream()
                                .filter(p -> p.getId().equals("sourceName")).findFirst().get().getArguments().get(0), variable);
                        return String.format("(for $%s in dataset %s return $%s)", exp.getId(), sourceName, exp.getId());
                    }
                    case FILTER: {
                        String id = exp.id.equals("") ? nextVar() : exp.id;
                        String schema = exp.getSchemaSize() == 0
                                ? "$" + id
                                : "{" + Joiner.on(", ").join(exp.getSchema().stream()
                                .map(s -> s.getId() + " : " + convert(s.getArguments().get(0), id)).collect(Collectors.toList()));
                        return String.format(
                                "for $%s in %s where %s return %s",
                                id,
                                convert(exp.getArguments().get(0), id),
                                convert(exp.getParameters().stream().filter(p ->
                                        p.id.equals("filterExpression")).findAny().get().getArguments().get(0), id),
                                schema);
                    }
                    default:
                        throw new UnsupportedOperationException(exp.queryType.name());
                }
            default:
                throw new UnsupportedOperationException(exp.type.name());
        }
    }

    private static boolean isNumeric(String str) {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
