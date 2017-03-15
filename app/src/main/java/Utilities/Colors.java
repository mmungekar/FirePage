package Utilities;

import android.support.annotation.ColorInt;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ritler on 3/15/17.
 */

public class Colors {
    @ColorInt public static final int BLACK       = 0xFF000000;
    @ColorInt public static final int DKGRAY      = 0xFF444444;
    @ColorInt public static final int GRAY        = 0xFF888888;
    @ColorInt public static final int LTGRAY      = 0xFFCCCCCC;
    @ColorInt public static final int WHITE       = 0xFFFFFFFF;
    @ColorInt public static final int RED         = 0xFFFF0000;
    @ColorInt public static final int GREEN       = 0xFF00FF00;
    @ColorInt public static final int BLUE        = 0xFF0000FF;
    @ColorInt public static final int YELLOW      = 0xFFFFFF00;
    @ColorInt public static final int CYAN        = 0xFF00FFFF;
    @ColorInt public static final int MAGENTA     = 0xFFFF00FF;
    @ColorInt public static final int HASHIRAMA   = 0xFFB0513C;
    @ColorInt public static final int MADARA      = 0xFF4C4C8A;
    @ColorInt public static final int PURPLEFLURP = 0xFFB266B2;
    @ColorInt public static final int LINK        = 0xFF7ED493;
    @ColorInt public static final int EXORCIST    = 0xFF4FC7D2;
    @ColorInt public static final int GILGAMESH   = 0xFFCCC810;
    @ColorInt public static final int NARUTO      = 0xFFCE7B12;
    @ColorInt public static final int TRANSPARENT = 0;
    ArrayList<Integer> colors = new ArrayList<>();
    public Colors(){
        addColors();

    }
    public void addColors(){
        colors.add(HASHIRAMA);
        colors.add(MADARA);
        colors.add(PURPLEFLURP);
        colors.add(LINK);
        colors.add(EXORCIST);
        colors.add(GILGAMESH);
        colors.add(NARUTO);
    }
    public Integer getColor(){
        int pos = new Random().nextInt(colors.size());
        Integer color = colors.get(pos);
        colors.remove(pos);
        if(colors.isEmpty()){
            addColors();
        }
        return color;
    }
}
