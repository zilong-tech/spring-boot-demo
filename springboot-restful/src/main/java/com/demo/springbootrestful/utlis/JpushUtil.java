package com.demo.springbootrestful.utlis;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JpushUtil {

    protected static final Logger LOG = LoggerFactory.getLogger(JpushUtil.class);

    protected static final String JPushURI = "https://api.jpush.cn/v3/push";

    protected static final String APP_KEY ="1ae72edda9a477068a0a4b89";
    protected static final String MASTER_SECRET = "d93bf746c6113648a0d1d6fb";
    protected static final String GROUP_PUSH_KEY = "2c88a01e073a0fe4fc7b167c";
    protected static final String GROUP_MASTER_SECRET = "b11314807507e2bcfdeebe2e";

    public static final String TITLE = "Test from API example";
    public static final String ALERT = "Test from API Example - alert";
    public static final String MSG_CONTENT = "Test from API Example - msgContent";
    public static final String REGISTRATION_ID = "0900e8d85ef";
    public static final String TAG = "tag_api";
    public static long sendCount = 0;
    private static long sendTotalTime = 0;


    public  static void testPushByRest(){



    }

    /**
     * 推送的关键在于构建一个 PushPayload 对象
     */
    public static void testSendPushWithCustomConfig() {
        ClientConfig config = ClientConfig.getInstance();
        // Setup the custom hostname
        //config.setPushHostName("https://api.jpush.cn");

        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, config);

        // For push, all you need do is to build PushPayload object.
       // PushPayload payload = buildPushObject_all_all_alert();
        //PushPayload payload = buildPushObject_android_tag_alertWithTitle();
        PushPayload payload = buildPushObject_ios_tagAnd_alertWithExtrasAndMessage();

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);

        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
    }

    /**
     * 推送对象：所有平台，所有设备，内容为 ALERT 的通知。
     * @return
     */
    public static PushPayload buildPushObject_all_all_alert() {

        return PushPayload.alertAll(ALERT);
    }

    /**
     * 构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT。
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias1"))
                .setNotification(Notification.alert(ALERT))
                .build();
    }

    /**
     * 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，
     * 内容是 Android 通知 ALERT，并且标题为 TITLE。
     * @return
     */
    public static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(ALERT, TITLE, null))
                .build();
    }

    /**
     * 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，推送内容同时包括通知与消息
     * - 通知信息是 ALERT，角标数字为 5，通知声音为 "happy"，并且附加字段 from = "JPush"；
     * 消息内容是 MSG_CONTENT。通知是 APNs 推送通道的，消息是 JPush 应用内消息通道的。
     * APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
     * @return
     */
    public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.tag_and("tag1", "tag_all"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(ALERT)
                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .build())
                .setMessage(Message.content(MSG_CONTENT))
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
    }


}
