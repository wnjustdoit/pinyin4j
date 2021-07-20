package net.sourceforge.pinyin4j.test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * NewPinyinHelperTest
 *
 * @author wangnan
 * @since 2020/5/29
 **/
public class NewPinyinHelperTest {


  @Test
  public void test() throws BadHanyuPinyinOutputFormatCombination {
    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
    format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
    format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

    String result1 = PinyinHelper.toHanYuPinyinString("你好啊", format, " ", true, true);
    assertEquals("nĭ hăo a", result1);

    String result0 =
        PinyinHelper.toHanYuPinyinString("他在宿舍里想了一宿，天上究竟有多少个星宿。", format, " ", true, true);
    assertEquals(
        "tā zài sù shè lĭ xiăng le yī xiŭ ， tiān shàng jiū jìng yŏu duō shăo gè xīng xiù 。",
        result0);

    String result2 = PinyinHelper.toHanYuPinyinString("春眠不觉晓，,!@#$处处闻啼鸟", format, " ", true, true);
    assertEquals("chūn mián bù jué xiăo ，,!@#$ chŭ chù wén tí niăo", result2);

    String result3 = PinyinHelper.toHanYuPinyinString("一日千里", format, " ", true, true);
    assertEquals("yī rì qiān lĭ", result3);

    String result4 = PinyinHelper.toHanYuPinyinString("大鱼吃小鱼,杨幂是个女的", format, " ", true, true);
    assertEquals("dà yú chī xiăo yú , yáng mì shì gè nǚ de", result4);

    String result5 = PinyinHelper.toHanYuPinyinString("嫲櫷", format, " ", true, true);
    assertEquals("mā guī", result5);

    String result6 = PinyinHelper.toHanYuPinyinString("浅浅淡淡ω", format, " ", true, true);
    assertEquals("jiān jiān dàn dàn ω", result6);



    assertEquals("yī rì qiān lĭ",
            PinyinHelper.toHanYuPinyinString("一日,千里", format, " ", false, false));

    assertEquals("yī rì qiān lĭ",
            PinyinHelper.toHanYuPinyinString("一日,千里", format, " ", false, true));

    assertEquals("yī rì qiān lĭ",
            PinyinHelper.toHanYuPinyinString(",一日千里", format, " ", false, false));

    assertEquals("yī rì qiān lĭ",
            PinyinHelper.toHanYuPinyinString(",一日,千里,", format, " ", false, false));

  }

}
