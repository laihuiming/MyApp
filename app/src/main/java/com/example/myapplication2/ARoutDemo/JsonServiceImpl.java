//package com.example.myapplication2.ARoutDemo;
//
//import android.content.Context;
//
//import com.alibaba.android.arouter.facade.annotation.Route;
//import com.alibaba.android.arouter.facade.service.SerializationService;
//import com.alibaba.fastjson.JSON;
//
//import java.lang.reflect.Type;
//
////@Route(path = "/service/json")
////public class JsonServiceImpl implements SerializationService {
////    @Override
////    public void init(Context context) {
////
////    }
////
////    @Override
////    public <T> T json2Object(String text, Class<T> clazz) {
////        return JSON.parseObject(text, clazz);
////    }
////
////    @Override
////    public String object2Json(Object instance) {
////        return JSON.toJSONString(instance);
////    }
////
////    @Override
////    public <T> T parseObject(String input, Type clazz) {
////        return JSON.parseObject(input, clazz);
////    }
////}
//// 如果需要传递自定义对象，新建一个类（并非自定义对象类），然后实现 SerializationService,并使用@Route注解标注(方便用户自行选择序列化方式)，例如：
//@Route(path = "/app/JsonServiceImpl")
//public class JsonServiceImpl implements SerializationService {
//    @Override
//    public void init(Context context) {
//
//    }
//
//    @Override
//    public <T> T json2Object(String text, Class<T> clazz) {
//        return JSON.parseObject(text, clazz);
//    }
//
//    @Override
//    public String object2Json(Object instance) {
//        return JSON.toJSONString(instance);
//    }
//
//    //
//    @Override
//    public <T> T parseObject(String input, Type clazz) {
//        return null;
//    }
//}