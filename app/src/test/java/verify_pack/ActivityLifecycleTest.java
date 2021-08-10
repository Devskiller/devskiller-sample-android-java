package verify_pack;

import static org.assertj.android.api.Assertions.assertThat;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import com.devskiller.calculator.calculator.MainActivity;
import com.devskiller.calculator.calculator.R;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.N)
public class ActivityLifecycleTest {

    private ActivityController<MainActivity> controller;
    private MainActivity activity;
    private TextView result;

    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(MainActivity.class);
        activity = controller.setup()
                .get();
        result = activity.findViewById(R.id.result);
    }

    @After
    public void tearDown() {
        controller.pause()
                .stop()
                .destroy();
    }

    @Test
    public void shouldKeepCalculatorValuesAfterActivityPauseAndResume() {
        // given
        activity.findViewById(R.id.btn1).performClick();
        activity.findViewById(R.id.btn2).performClick();
        activity.findViewById(R.id.btn3).performClick();

        // when
        controller.pause().resume();

        // then
        assertThat(result).hasText("123");
    }

    @Test
    public void shouldKeepCalculatorFunctionalAfterActivityRecreation() {
        // given
        activity.findViewById(R.id.btn1).performClick();
        activity.findViewById(R.id.btn2).performClick();
        activity.findViewById(R.id.btn3).performClick();

        Bundle bundle = new Bundle();

        // when
        destroyOriginalActivity(bundle);
        bringUpOriginalActivity(bundle);
        activity.findViewById(R.id.btn4).performClick();

        // then
        assertThat(result).hasText("1234");
    }

    @Test
    public void shouldStillDisplayErrorAfterActivityRecreation() {
        activity.findViewById(R.id.btn2).performClick();
        activity.findViewById(R.id.btnDivide).performClick();
        activity.findViewById(R.id.btn0).performClick();
        activity.findViewById(R.id.btnEqual).performClick();

        Bundle bundle = new Bundle();

        // when
        destroyOriginalActivity(bundle);
        bringUpOriginalActivity(bundle);

        assertThat(result).hasText("E");
    }

    private void bringUpOriginalActivity(Bundle bundle) {
        controller = Robolectric.buildActivity(MainActivity.class)
                .setup(bundle);
        activity = controller.get();
        result = activity.findViewById(R.id.result);
    }

    private void destroyOriginalActivity(Bundle bundle) {
        controller.saveInstanceState(bundle)
                .pause()
                .stop()
                .destroy();
    }
}
