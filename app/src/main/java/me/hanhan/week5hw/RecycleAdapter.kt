package me.hanhan.week5hw

import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle





class RecycleAdapter(private val context: Context, var data: List<Dog>) : RecyclerView.Adapter<RecycleAdapter.VH>() {

    private var position = 0

    //内部类 继承
    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        val dogName: TextView = v.findViewById(R.id.dog_name)
        val dogImg: ImageView = v.findViewById(R.id.dog_img)
        val dogRegion: TextView = v.findViewById(R.id.dog_region)
    }

    //在该方法中创建ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_adapter, parent, false)
        var vh = VH(view)
        vh.itemView.setOnClickListener {
            //拿到用户点击的位置
            position = vh.adapterPosition
            var dog = data[position]
            Toast.makeText(context, "你点击了->" + dog.name, Toast.LENGTH_SHORT).show()
            var intent = Intent(
                context,
                DogShow::class.java
            )
            val bundle = Bundle()
            bundle.putString("dog_show_name",dog.name)
            bundle.putInt("dog_show_img",dog.ImgId)
            bundle.putString("dog_show_region", dog.region)
            bundle.putString("dog_contact", dog.contact)
            bundle.putString("dog_phone", dog.phone)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
        return vh
    }

    //在该方法中数据绑定
    override fun onBindViewHolder(holder: VH, position: Int) {
        var dog = data[position]
        holder.dogName.text = dog.name
        holder.dogImg.setImageResource(dog.ImgId)
        holder.dogRegion.text = dog.region
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getPosition(): Int {
        return position
    }

    fun updateItems() {
        notifyDataSetChanged()
    }
}