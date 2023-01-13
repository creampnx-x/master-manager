package com.example.mastermanager.module1.pojo;

    public class Choose {//选课申请
        private String mname;//研究生姓名

        private int mid;//研究生id，下同

        private String cname;//课程名称

        private int cid;

        private int tid;

        private int state;//表示申请是否审核 -1不通过 0未审核  1已审核

        public String getMname() {
            return mname;
        }

        public int getMid() {
            return mid;
        }

        public String getCname() {
            return cname;
        }

        public int getCid() {
            return cid;
        }


        public int getTid() {
            return tid;
        }

        public void setMname(String mname) {
            this.mname = mname;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }


        public void setTid(int tid) {
            this.tid = tid;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Choose(String mname, int mid, String cname, int cid, int tid,int state) {
            this.mname = mname;
            this.mid = mid;
            this.cname = cname;
            this.cid = cid;
            this.tid = tid;
            this.state = state;
        }

    }
