package com.fxb.blog.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Freemarker模板操作工具类
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
public class FreeMarkerUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FreeMarkerUtil.class);

    private static final String LT = "<";
    private static final String LT_CHAR = "&lt;";
    private static final String GT = ">";
    private static final String GT_CHAR = "&gt;";
    private static final String AMP = "&";
    private static final String AMP_CHAR = "&amp;";
    private static final String APOS = "'";
    private static final String APOS_CHAR = "&apos;";
    private static final String QUOT = "&quot;";
    private static final String QUOT_CHAR = "\"";

    /**
     * Template to String Method Note
     *
     * @param templateContent
     *         template content
     * @param map
     *         tempate data map
     * @return
     */
    public static String template2String(String templateContent, Map<String, Object> map,
                                         boolean isNeedFilter) {
        if (StringUtils.isEmpty(templateContent)) {
            return null;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> newMap = new HashMap<>(1);

        Set<String> keySet = map.keySet();
        if (keySet.size() > 0) {
            for (String key : keySet) {
                Object o = map.get(key);
                if (o != null) {
                    if (o instanceof String) {
                        String value = o.toString();
                        if (value != null) {
                            value = value.trim();
                        }
                        if (isNeedFilter) {
                            value = filterXmlString(value);
                        }
                        newMap.put(key, value);
                    } else {
                        newMap.put(key, o);
                    }
                }
            }
        }
        Template t = null;
        try {
            t = new Template("", new StringReader(templateContent), new Configuration());
            StringWriter writer = new StringWriter();
            t.process(newMap, writer);
            return writer.toString();
        } catch (IOException e) {
            LOG.error("TemplateUtil -> template2String IOException.", e);
        } catch (TemplateException e) {
            LOG.error("TemplateUtil -> template2String TemplateException.", e);
        } finally {
            if (newMap != null) {
                newMap.clear();
                newMap = null;
            }
        }
        return null;
    }

    protected static String filterXmlString(String str) {
        str = str.replaceAll(LT, LT_CHAR);
        str = str.replaceAll(GT, GT_CHAR);
        str = str.replaceAll(AMP, AMP_CHAR);
        str = str.replaceAll(APOS, APOS_CHAR);
        str = str.replaceAll(QUOT, QUOT_CHAR);
        return str;
    }
}
