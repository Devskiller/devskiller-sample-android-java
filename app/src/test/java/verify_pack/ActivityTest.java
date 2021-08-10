package verify_pack;

import static org.assertj.android.api.Assertions.assertThat;

import android.app.Activity;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.devskiller.calculator.calculator.MainActivity;
import com.devskiller.calculator.calculator.R;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.N)
public class ActivityTest {

    private TextView result;
    private Activity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
        result = activity.findViewById(R.id.result);
    }

    @Test
    public void shouldClearLatestDigitWhenBackIsPressed() {
        // given
        activity.findViewById(R.id.btn1).performClick();
        activity.findViewById(R.id.btn2).performClick();
        activity.findViewById(R.id.btn3).performClick();

        // when
        activity.findViewById(R.id.backspace).performClick();

        // then
        assertThat(result).hasText("12");
    }

    @Test
    public void shouldAdd() {
        // given
        activity.findViewById(R.id.btn2).performClick();
        activity.findViewById(R.id.btnAdd).performClick();
        activity.findViewById(R.id.btn2).performClick();

        // when
        activity.findViewById(R.id.btnEqual).performClick();

        // then
        assertThat(result).hasText("4");
    }

    @Test
    public void shouldSubstract() {
        // given
        activity.findViewById(R.id.btn3).performClick();
        activity.findViewById(R.id.btnSubstract).performClick();
        activity.findViewById(R.id.btn2).performClick();

        // when
        activity.findViewById(R.id.btnEqual).performClick();

        // then
        assertThat(result).hasText("1");
    }

    @Test
    public void shouldMultiply() {
        // given
        activity.findViewById(R.id.btn3).performClick();
        activity.findViewById(R.id.btnMultiply).performClick();
        activity.findViewById(R.id.btn2).performClick();

        // when
        activity.findViewById(R.id.btnEqual).performClick();

        // then
        assertThat(result).hasText("6");
    }

    @Test
    public void shouldDivide() {
        // given
        activity.findViewById(R.id.btn8).performClick();
        activity.findViewById(R.id.btnDivide).performClick();
        activity.findViewById(R.id.btn2).performClick();

        // when
        activity.findViewById(R.id.btnEqual).performClick();

        // then
        assertThat(result).hasText("4");
    }

    @Test
    public void shouldReportErrorWhenDivideByZero() {
        // given
        activity.findViewById(R.id.btn8).performClick();
        activity.findViewById(R.id.btnDivide).performClick();
        activity.findViewById(R.id.btn0).performClick();

        // when
        activity.findViewById(R.id.btnEqual).performClick();

        // then
        assertThat(result).hasText("E");
    }

    @Test
    public void shouldClearScreenWhenCEIsPressed() {
        // given
        activity.findViewById(R.id.btn1).performClick();
        activity.findViewById(R.id.btn2).performClick();

        // when
        activity.findViewById(R.id.ce).performClick();

        // then
        assertThat(result).hasText("0");
    }
}
