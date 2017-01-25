package com.example.anas.school;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView_news,recyclerView_lohetSharaf;
    private RecyclerView.LayoutManager newsLayoutManger,lohetsharafLayoutManager;
    NewsAdapter newsAdapter ;
    LohetSharafAdapter lohetSharafAdapter;
    List<News> newsList ;
    List<LohetSharaf>lohetSharafList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newsList =new ArrayList<News>();
        newsAdapter=new NewsAdapter(newsList);

        lohetSharafList=new ArrayList<>();
        lohetSharafAdapter=new LohetSharafAdapter(lohetSharafList);

        recyclerView_news = (RecyclerView)findViewById(R.id.recyclerview_news_id);
        recyclerView_news.setHasFixedSize(true);
        newsLayoutManger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_news.setLayoutManager(newsLayoutManger);
        recyclerView_news.setAdapter(newsAdapter);

        recyclerView_news.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        News news=newsList.get(position);
                        Intent intent =new Intent(MainActivity.this,DetailsNews.class);
                        intent.putExtra("news", news);

                        //Start details activity
                        startActivity(intent);

                    }
                })
        );


        recyclerView_lohetSharaf = (RecyclerView)findViewById(R.id.recyclerview_lohetsharf_id);
        recyclerView_lohetSharaf.setHasFixedSize(true);
        lohetsharafLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_lohetSharaf.setLayoutManager(lohetsharafLayoutManager);
        recyclerView_lohetSharaf.setAdapter(lohetSharafAdapter);
        recyclerView_lohetSharaf.scrollToPosition(1);

        findViewById(R.id.bt_montada_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WebView.class));
            }
        });


        findViewById(R.id.bt_faaliat_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,WebView.class));
            }
        });


        findViewById(R.id.bt_medya_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,WebView.class));
            }
        });

        findViewById(R.id.bt_aboutus_id)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"dddddddd",Toast.LENGTH_LONG).show();
                    }
                });


        findViewById(R.id.bt_message_id)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                    }
                });

        prepareData();
        lohetSharaf();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {
            startActivity(new Intent(MainActivity.this,Login.class));
            return true;
        }else if (id==R.id.action_register){
            startActivity(new Intent(MainActivity.this,Register.class));
            return true;

        }

        return super.onOptionsItemSelected(item);
    }


    private void prepareData(){
        News news =new News(" أكدت أبحاث عديد من العلماء على الأثر القوي للتعليم على الإنتاج وعلى التطور الاقتصادي والتقدم التقني، فخلف كل مظاهر التقدم التقني والاقتصادي تكمن جهود العلماء الباحثين في مختبراتهم. فمؤسسات البحث العلمي تلعب دورا مهما في تطوير الإنشاءات، وضمان نجاح التخطيطات الاقتصادية وتصحيحها وتقييمها. كما تؤدي البحوث إلى حدوث اكتشافات علمية تؤثر في طبيعة فهم الإنسان ونظرته إلى العالم وفي كشف مناطق جديدة من المعلومات والاحتمالات التطبيقية التي تتحول إلى وسائل وأدوات تكنولوجية للإنتاج والمواصلات وغيرها؛\n" +
                "فالبحث العلمي هو استنباط للمعرفة، وتطوير لمنتج، وتخلف البحث العلمي في القطاع الصناعي أو الاجتماعي أو غيره يحول دون تطوير هذه القطاعات والتغلب على مشاكلها؛ وبالتالي فإنه لا يمكن مع هذا التخلف تطوير تكنولوجيات أو تحسين مستويات هذه القطاعات ولا النهوض بها ولا إنتاج الثروات.\n" +
                "إن الاستقلالية التكنولوجية، وإخضاع هذه المعارف وتطويرها رهين بالبحث العلمي وسياسة واستثمار الموارد البشرية، والجامعات بما تضمه من مخابر البحث، وورش التجريب ومدرجات التدريس تعد من أهم وسائل إعداد الطاقة البشرية وصقلها، وتنمية مهاراتها بالعلم والمعرفة والتدريب.\n" +
                "يلاحظ بعض الباحثين أن جامعاتنا لا تقر سياسات البحث العلمي، ولا تحدد أهدافًا إستراتيجية على المدى القصير ولا على المدى الطويل ولا المتوسط، ولا تضم البرامج السنوية للجامعات برامج بحوث بالمفهوم العالمي إلا نادرا، وغالبا ما تكون مشاريع البحوث المنجزة من تلقاء مبادرة فردية أو مجموعات بحث صغيرة.\n" +
                "فهذه الجامعات لم تكن مجالا للبحث العلمي قط. فقد انهمكت بعد حصول بلداننا على الاستقلال في تكوين الأطر من أطباء وحقوقيين ومدرسين ورجال إدارة؛ ليحلوا محل الأطر الاستعمارية، واستمرت هذه الوضعية ردحا من الزمن، وبعد ذلك عند دخول هذه الدول فيما يسمى بالتقويم الهيكلي الاقتصادي الذي أملاه صندوق النقد الدولي، قلت الاعتمادات المالية والنفقات الاستثمارية في التعليم وفي سائر القطاعات. فبدأت ظاهرة بطالة الخريجين التي ما زلنا نعانيها: طوابير من المتعلمين والكفاءات معطلة عن الإنتاج، لا تتاح لها فرصة القيام بدور منتج، مشلولة مهمشة، رغم الحاجة الوطنية الملحة إلى المتعلمين كافة وفي سائر التخصصات.");
        newsList.add(news);

        news =new News("أكدت أبحاث عديد من العلماء على الأثر القوي للتعليم على الإنتاج وعلى التطور الاقتصادي والتقدم التقني، فخلف كل مظاهر التقدم التقني والاقتصادي تكمن جهود العلماء الباحثين في مختبراتهم. فمؤسسات البحث العلمي تلعب دورا مهما في تطوير الإنشاءات، وضمان نجاح التخطيطات الاقتصادية وتصحيحها وتقييمها. كما تؤدي البحوث إلى حدوث اكتشافات علمية تؤثر في طبيعة فهم الإنسان ونظرته إلى العالم وفي كشف مناطق جديدة من المعلومات والاحتمالات التطبيقية التي تتحول إلى وسائل وأدوات تكنولوجية للإنتاج والمواصلات وغيرها؛\n" +
                "فالبحث العلمي هو استنباط للمعرفة، وتطوير لمنتج، وتخلف البحث العلمي في القطاع الصناعي أو الاجتماعي أو غيره يحول دون تطوير هذه القطاعات والتغلب على مشاكلها؛ وبالتالي فإنه لا يمكن مع هذا التخلف تطوير تكنولوجيات أو تحسين مستويات هذه القطاعات ولا النهوض بها ولا إنتاج الثروات.");
        newsList.add(news);

        news =new News("أكدت أبحاث عديد من العلماء على الأثر القوي للتعليم على الإنتاج وعلى التطور الاقتصادي والتقدم التقني، فخلف كل مظاهر التقدم التقني والاقتصادي تكمن جهود العلماء الباحثين في مختبراتهم. فمؤسسات البحث العلمي تلعب دورا مهما في تطوير الإنشاءات، وضمان نجاح التخطيطات الاقتصادية وتصحيحها وتقييمها. كما تؤدي البحوث إلى حدوث اكتشافات علمية تؤثر في طبيعة فهم الإنسان ونظرته إلى العالم وفي كشف مناطق جديدة من المعلومات والاحتمالات التطبيقية التي تتحول إلى وسائل وأدوات تكنولوجية للإنتاج والمواصلات وغيرها؛\n" +
                "فالبحث العلمي هو استنباط للمعرفة، وتطوير لمنتج، وتخلف البحث العلمي في القطاع الصناعي أو الاجتماعي أو غيره يحول دون تطوير هذه القطاعات والتغلب على مشاكلها؛ وبالتالي فإنه لا يمكن مع هذا التخلف تطوير تكنولوجيات أو تحسين مستويات هذه القطاعات ولا النهوض بها ولا إنتاج الثروات.");
        newsList.add(news);

        news =new News("أكدت أبحاث عديد من العلماء على الأثر القوي للتعليم على الإنتاج وعلى التطور الاقتصادي والتقدم التقني، فخلف كل مظاهر التقدم التقني والاقتصادي تكمن جهود العلماء الباحثين في مختبراتهم. فمؤسسات البحث العلمي تلعب دورا مهما في تطوير الإنشاءات، وضمان نجاح التخطيطات الاقتصادية وتصحيحها وتقييمها. كما تؤدي البحوث إلى حدوث اكتشافات علمية تؤثر في طبيعة فهم الإنسان ونظرته إلى العالم وفي كشف مناطق جديدة من المعلومات والاحتمالات التطبيقية التي تتحول إلى وسائل وأدوات تكنولوجية للإنتاج والمواصلات وغيرها؛\n" +
                "فالبحث العلمي هو استنباط للمعرفة، وتطوير لمنتج، وتخلف البحث العلمي في القطاع الصناعي أو الاجتماعي أو غيره يحول دون تطوير هذه القطاعات والتغلب على مشاكلها؛ وبالتالي فإنه لا يمكن مع هذا التخلف تطوير تكنولوجيات أو تحسين مستويات هذه القطاعات ولا النهوض بها ولا إنتاج الثروات.");
        newsList.add(news);

        news =new News("أكدت أبحاث عديد من العلماء على الأثر القوي للتعليم على الإنتاج وعلى التطور الاقتصادي والتقدم التقني، فخلف كل مظاهر التقدم التقني والاقتصادي تكمن جهود العلماء الباحثين في مختبراتهم. فمؤسسات البحث العلمي تلعب دورا مهما في تطوير الإنشاءات، وضمان نجاح التخطيطات الاقتصادية وتصحيحها وتقييمها. كما تؤدي البحوث إلى حدوث اكتشافات علمية تؤثر في طبيعة فهم الإنسان ونظرته إلى العالم وفي كشف مناطق جديدة من المعلومات والاحتمالات التطبيقية التي تتحول إلى وسائل وأدوات تكنولوجية للإنتاج والمواصلات وغيرها؛\n" +
                "فالبحث العلمي هو استنباط للمعرفة، وتطوير لمنتج، وتخلف البحث العلمي في القطاع الصناعي أو الاجتماعي أو غيره يحول دون تطوير هذه القطاعات والتغلب على مشاكلها؛ وبالتالي فإنه لا يمكن مع هذا التخلف تطوير تكنولوجيات أو تحسين مستويات هذه القطاعات ولا النهوض بها ولا إنتاج الثروات.");
        newsList.add(news);

        news =new News("أكدت أبحاث عديد من العلماء على الأثر القوي للتعليم على الإنتاج وعلى التطور الاقتصادي والتقدم التقني، فخلف كل مظاهر التقدم التقني والاقتصادي تكمن جهود العلماء الباحثين في مختبراتهم. فمؤسسات البحث العلمي تلعب دورا مهما في تطوير الإنشاءات، وضمان نجاح التخطيطات الاقتصادية وتصحيحها وتقييمها. كما تؤدي البحوث إلى حدوث اكتشافات علمية تؤثر في طبيعة فهم الإنسان ونظرته إلى العالم وفي كشف مناطق جديدة من المعلومات والاحتمالات التطبيقية التي تتحول إلى وسائل وأدوات تكنولوجية للإنتاج والمواصلات وغيرها؛\n" +
                "فالبحث العلمي هو استنباط للمعرفة، وتطوير لمنتج، وتخلف البحث العلمي في القطاع الصناعي أو الاجتماعي أو غيره يحول دون تطوير هذه القطاعات والتغلب على مشاكلها؛ وبالتالي فإنه لا يمكن مع هذا التخلف تطوير تكنولوجيات أو تحسين مستويات هذه القطاعات ولا النهوض بها ولا إنتاج الثروات.");
        newsList.add(news);
        newsAdapter.notifyDataSetChanged();

    }
    private void lohetSharaf(){
        LohetSharaf lohetSharaf=new LohetSharaf("احمد محمود","الصف الثالث ");
        lohetSharafList.add(lohetSharaf);

        lohetSharaf=new LohetSharaf("محمد رضا","الصف الاول");
        lohetSharafList.add(lohetSharaf);

        lohetSharaf=new LohetSharaf("اسلام على","الصف الثانى ");
        lohetSharafList.add(lohetSharaf);

        lohetSharafAdapter.notifyDataSetChanged();
    }
}
