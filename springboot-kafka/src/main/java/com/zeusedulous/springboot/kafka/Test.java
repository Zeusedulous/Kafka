package com.zeusedulous.springboot.kafka;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Zeusedulous
 * @Date : 2020/7/14 10:10
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        List<OrgOrUserFields> userSearchFields = new ArrayList<>();
        userSearchFields.add(new OrgOrUserFields("name", "姓名", true));
        userSearchFields.add(new OrgOrUserFields("realName", "真实姓名", false));
        userSearchFields.add(new OrgOrUserFields("id", "用户ID", false));
        userSearchFields.add(new OrgOrUserFields("survival", "账号状态", false));

        List<String> list = new ArrayList<>();
        list.add("realName");
//        list.add("survival");
        list.add("name");
        list.add("id");

        LinkedHashMap map = new LinkedHashMap();
        userSearchFields.stream().forEach(user->{
            map.put(user.key,user);
        });

        List<OrgOrUserFields> temp = new ArrayList<>();

        list.stream().forEach(l->{
            OrgOrUserFields user = (OrgOrUserFields) map.get(l);
            user.isSelect = true;
            temp.add(user);
        });

        System.out.println("temp = " + temp);

//        int index =0;
//        for (int i = 0;i<list.size();i++){
//            int finalIndex = index;
//            userSearchFields.stream().forEach(user->{
//                if(user.key.equals(list.get(finalIndex))){
//                    user.isSelect = true;
//                    temp.add(user);
//                    return;
//                }
//            });
//            index++;
//        }
//
//        List<OrgOrUserFields> temp2 = new ArrayList<>();
//        temp2.addAll(temp);
//
//        for (int i=0;i<userSearchFields.size();i++){
//            if(!temp.contains(userSearchFields.get(i))){
//                OrgOrUserFields user = userSearchFields.get(i);
//                user.isSelect = false;
//                temp2.add(user);
//            }
//        }


//        System.out.println("temp2 = " + temp2);

    }

    public static class OrgOrUserFields {
        private String key;

        private String name;

        private boolean isSelect;

        OrgOrUserFields(String key,String name,boolean isSelect){
            this.key = key;
            this.name = name;
            this.isSelect = isSelect;
        }

        @Override
        public String toString() {
            return "{" +
                    "key='" + key + '\'' +
                    ", name='" + name + '\'' +
                    ", isSelect=" + isSelect +
                    '}';
        }
    }

}
