
struct HostInfo {
  1: i64 port,
  2: string addr,
}

struct HostTask {
  1: optional list<HostInfo> notifyAddr,
  2: optional list<HostInfo> outputAddr,
}
