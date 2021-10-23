package me.hanhan.week5hw

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var data = ArrayList<Dog>()
    private lateinit var adapter: RecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 1..2) {
            data.add(Dog("比熊", R.drawable.dog0, "上海  闵行", "李先生","13789234673"))
            data.add(Dog("柯基", R.drawable.dog1, "上海  徐汇", "韩女士", "13678923456"))
            data.add(Dog("比熊", R.drawable.dog2, "上海  静安", "郑先生", "13497345012"))
            data.add(Dog("雪纳瑞", R.drawable.dog3, "上海  浦东", "刘女士", "13784527901"))
            data.add(Dog("牧羊犬", R.drawable.dog4, "河南  郑州", "黄先生", "13867013659"))
            data.add(Dog("柴犬", R.drawable.dog5, "山东  济南", "李女士", "13589234671"))
            data.add(Dog("牧羊犬", R.drawable.dog6, "江苏  南京", "王先生", "12903789237"))
            data.add(Dog("萨摩耶", R.drawable.dog7, "浙江  杭州", "刘女士", "15782396156"))
            data.add(Dog("柴犬", R.drawable.dog8, "河北  石家庄", "王先生", "18972347819"))
            data.add(Dog("柯基", R.drawable.dog9, "河南  信阳", "刘女士", "13092781673"))
            data.add(Dog("雪纳瑞", R.drawable.dog10, "河南  商丘", "韩先生", "18723778912"))
            data.add(Dog("柯基", R.drawable.dog11, "山东  威海", "郑女士", "15672837169"))
        }
        var manager = GridLayoutManager(this, 1)

        //初始化适配器
        adapter = RecycleAdapter(this, data)
        val dogList = findViewById<RecyclerView>(R.id.dog_list)

        dogList.layoutManager = manager
        adapter.updateItems()
        dogList.adapter = adapter

    }

}