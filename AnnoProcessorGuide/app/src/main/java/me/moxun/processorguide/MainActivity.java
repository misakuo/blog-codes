package me.moxun.processorguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.moxun.MetaLoader;
import com.moxun.anno.Meta;

public class MainActivity extends AppCompatActivity {

    @Meta(repeat = 1, id = "Oo")
    public String a;

    @Meta(repeat = 2, id = "Xx")
    public String b;

    @Meta(repeat = 3, id = "Kk")
    public String c;

    @Meta(repeat = 2, id = "Vv")
    protected String d;

    @Meta(repeat = 2, id = "Ss")
    private String e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MetaLoader.load(this);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(toString());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("a='").append(a).append('\'');
        sb.append(", b='").append(b).append('\'');
        sb.append(", c='").append(c).append('\'');
        sb.append(", d='").append(d).append('\'');
        sb.append(", e='").append(e).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
