
include "data.thrift"
include "communications.thrift"
include "expression.thrift"

service Hosting {
   
  i64 ntf(),

  i64 execute(1: expression.ThriftExpression query),    

  i64 setTask(1: communications.HostTask task, 2: expression.ThriftExpression query),

  i64 getData(1: data.Data rdata)

}
