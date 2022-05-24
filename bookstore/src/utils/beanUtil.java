package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author Charon
 * @date 2020/7/10
 **/
public class beanUtil {

    /**
     * 把Map注入到javaBean属性中
     * @param map
     * @param been
     * @param <T>
     * @return
     */
    public static <T> T copyParaToBean(Map map, T been){

        try {
            //System.out.println("注入前："+been);
            BeanUtils.populate(been,map);
            //System.out.println("注入后："+been);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return been;

    }

    public static int ParseInt(String s,int defaultValue){

        try {
            if (s==null|| s.equals("")){
                return defaultValue;
            }else {
                return Integer.parseInt(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }


    /**
     * dao层
     * service层
     * web层（servlet）
     * 使用HttpServletRequest request，只能应用在web层，并且最后传入的参数类型是 Map集合
     * 而直接使用 Map类型作为参数的话，在三层中都能使用，降低了代码的耦合性，提高了扩张性
     *
     * @param request
     * @param been
     */
   /* public static void copyParaToBean(HttpServletRequest request, Object been){

        try {
            System.out.println("注入前："+been);
            BeanUtils.populate(been,request.getParameterMap());
            System.out.println("注入后："+been);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}
