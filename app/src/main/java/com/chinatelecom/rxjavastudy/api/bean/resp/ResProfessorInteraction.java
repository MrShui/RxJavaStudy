package com.chinatelecom.rxjavastudy.api.bean.resp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 专家互动
 * Created by Shui on 16/10/25.
 */

public class ResProfessorInteraction {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("content_title")
    private String contentTitle;
    @SerializedName("content")
    private String content;
    @SerializedName("host")
    private String host;
    @SerializedName("expert_personal_view")
    private String expertPersonalView;
    @SerializedName("title_image")
    private String titleImage;
    @SerializedName("content_image")
    private String contentImage;
    @SerializedName("status")
    private String status;
    @SerializedName("question_num")
    private String questionNum;
    @SerializedName("answer_num")
    private String answerNum;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("update_time")
    private String updateTime;
    @SerializedName("tiwen_num")
    private int tiwenNum;
    @SerializedName("huifu_num")
    private int huifuNum;
    /**
     * id : 58
     * username : 邱世界
     * avatar : http://res2.ytxtv.com/avatar/AVAT580a29cb73868ee.jpg
     * identity : 44
     * create_time : 2016-10-21 22:44:27
     * update_time : 2016-10-22 18:10:58
     */

    @SerializedName("expert_id")
    private List<ExpertIdBean> expertId;
    /**
     * id : 1
     * parent_id : 11
     * user_id : {"user_id":1,"mobile":"15221776265","nickname":"用户3946884","avatar":"","qq":null,"wechat":null,"weibo":null,"status":1,"refresh_frequency":1,"living_room_id":0,"grade":1}
     * content : 如果将URL省略掉入口脚本，并将路由信息转换成路径，上面的URL就会变成： http://www.digpage.com/post/view?id=100 ， 是不是看起来舒服很多
     * <p>
     * status : 1
     * create_time : 2016-10-11 10:10:47
     * update_time : 2天前
     * expert_reply_tie : [{"id":3,"expert_id":57,"parent_id":1,"avatar":"http://res2.ytxtv.com/avatar/AVAT580a234e033d2ee.jpg","identity":"33333333333","username":"opop","content":"我十分气愤","status":1,"time":"2天前","create_time":"2016-10-22 19:40:29","update_time":"2016-10-22 19:42:28"}]
     */

    @SerializedName("reply_hot_tie")
    private List<ReplyHotTieBean> replyHotTie;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getExpertPersonalView() {
        return expertPersonalView;
    }

    public void setExpertPersonalView(String expertPersonalView) {
        this.expertPersonalView = expertPersonalView;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getContentImage() {
        return contentImage;
    }

    public void setContentImage(String contentImage) {
        this.contentImage = contentImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }

    public String getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getTiwenNum() {
        return tiwenNum;
    }

    public void setTiwenNum(int tiwenNum) {
        this.tiwenNum = tiwenNum;
    }

    public int getHuifuNum() {
        return huifuNum;
    }

    public void setHuifuNum(int huifuNum) {
        this.huifuNum = huifuNum;
    }

    public List<ExpertIdBean> getExpertId() {
        return expertId;
    }

    public void setExpertId(List<ExpertIdBean> expertId) {
        this.expertId = expertId;
    }

    public List<ReplyHotTieBean> getReplyHotTie() {
        return replyHotTie;
    }

    public void setReplyHotTie(List<ReplyHotTieBean> replyHotTie) {
        this.replyHotTie = replyHotTie;
    }

    public static class ExpertIdBean {
        @SerializedName("id")
        private String id;
        @SerializedName("username")
        private String username;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("identity")
        private String identity;
        @SerializedName("create_time")
        private String createTime;
        @SerializedName("update_time")
        private String updateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class ReplyHotTieBean {
        @SerializedName("id")
        private String id;
        @SerializedName("parent_id")
        private String parentId;
        /**
         * user_id : 1
         * mobile : 15221776265
         * nickname : 用户3946884
         * avatar :
         * qq : null
         * wechat : null
         * weibo : null
         * status : 1
         * refresh_frequency : 1
         * living_room_id : 0
         * grade : 1
         */

        @SerializedName("user_id")
        private UserIdBean userId;
        @SerializedName("content")
        private String content;
        @SerializedName("status")
        private String status;
        @SerializedName("create_time")
        private String createTime;
        @SerializedName("update_time")
        private String updateTime;
        /**
         * id : 3
         * expert_id : 57
         * parent_id : 1
         * avatar : http://res2.ytxtv.com/avatar/AVAT580a234e033d2ee.jpg
         * identity : 33333333333
         * username : opop
         * content : 我十分气愤
         * status : 1
         * time : 2天前
         * create_time : 2016-10-22 19:40:29
         * update_time : 2016-10-22 19:42:28
         */

        @SerializedName("expert_reply_tie")
        private List<ExpertReplyTieBean> expertReplyTie;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public UserIdBean getUserId() {
            return userId;
        }

        public void setUserId(UserIdBean userId) {
            this.userId = userId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public List<ExpertReplyTieBean> getExpertReplyTie() {
            return expertReplyTie;
        }

        public void setExpertReplyTie(List<ExpertReplyTieBean> expertReplyTie) {
            this.expertReplyTie = expertReplyTie;
        }

        public static class UserIdBean {
            @SerializedName("user_id")
            private int userId;
            @SerializedName("mobile")
            private String mobile;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("qq")
            private Object qq;
            @SerializedName("wechat")
            private Object wechat;
            @SerializedName("weibo")
            private Object weibo;
            @SerializedName("status")
            private int status;
            @SerializedName("refresh_frequency")
            private int refreshFrequency;
            @SerializedName("living_room_id")
            private int livingRoomId;
            @SerializedName("grade")
            private int grade;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public Object getWechat() {
                return wechat;
            }

            public void setWechat(Object wechat) {
                this.wechat = wechat;
            }

            public Object getWeibo() {
                return weibo;
            }

            public void setWeibo(Object weibo) {
                this.weibo = weibo;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getRefreshFrequency() {
                return refreshFrequency;
            }

            public void setRefreshFrequency(int refreshFrequency) {
                this.refreshFrequency = refreshFrequency;
            }

            public int getLivingRoomId() {
                return livingRoomId;
            }

            public void setLivingRoomId(int livingRoomId) {
                this.livingRoomId = livingRoomId;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }
        }

        public static class ExpertReplyTieBean {
            @SerializedName("id")
            private int id;
            @SerializedName("expert_id")
            private int expertId;
            @SerializedName("parent_id")
            private int parentId;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("identity")
            private String identity;
            @SerializedName("username")
            private String username;
            @SerializedName("content")
            private String content;
            @SerializedName("status")
            private int status;
            @SerializedName("time")
            private String time;
            @SerializedName("create_time")
            private String createTime;
            @SerializedName("update_time")
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getExpertId() {
                return expertId;
            }

            public void setExpertId(int expertId) {
                this.expertId = expertId;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getIdentity() {
                return identity;
            }

            public void setIdentity(String identity) {
                this.identity = identity;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
