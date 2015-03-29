
enum AttrValType {
  STR = 1,
  DBL = 2,
  LNG = 3
}

struct AttrInfo {
  1: string name,
  2: AttrValType type,
}

struct AttrVal {
  1: optional string sv,
  2: optional i64 iv,
  3: optional double dv,
}

struct Record {
  1: list<AttrVal> attrs,
}

struct Data {
  1: string id,
  2: list<AttrInfo> info,
  3: list<Record> val,
}


