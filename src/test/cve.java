package test;

import java.util.HashMap;

public class cve {

    public static class CveInfo {
        public String type;//攻击类型
        public String cveId;//cve编号
        public String detail;//漏洞名称

        public CveInfo(String type, String cveId, String detail) {
            this.type = type;
            this.cveId = cveId;
            this.detail = detail;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCveId() {
            return cveId;
        }

        public void setCveId(String cveId) {
            this.cveId = cveId;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @Override
        public String toString() {
            return "CveInfo{" +
                    "type='" + type + '\'' +
                    ", cveId='" + cveId + '\'' +
                    ", detail='" + detail + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        HashMap<String, CveInfo> cve = new HashMap<>();
        cve.put("bof",new CveInfo("bof","CVE-2019-1043","Microsoft Windows 缓冲区错误漏洞"));
        cve.put("eternalblue",new CveInfo("eternalblue","CVE-2017-0146","Microsoft Windows SMB 输入验证漏洞"));
        cve.put("dos",new CveInfo("dos","CVE=Null","dos攻击"));
        cve.put("scan",new CveInfo("scan","CVE=Null","scan扫描攻击"));
        System.out.println(cve.get("bof000"));
    }
}
