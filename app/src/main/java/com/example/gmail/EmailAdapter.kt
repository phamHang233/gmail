package com.example.gmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emailList: List<EmailItem>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    private val selectedItems = mutableSetOf<Int>()
    private val selectedStars = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_list_view, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val currentItem = emailList[position]
        holder.senderName.text = currentItem.senderName
        holder.emailSubject.text = currentItem.emailSubject

        if ( currentItem.selected){
            holder.senderImage.setImageResource(R.drawable.tick_black)
            holder.itemView.setBackgroundResource(R.drawable.selected_item)
        }
        else{
            holder.senderImage.setImageResource(R.drawable.user)

        }
        if ( currentItem.selectedStar == true){
            holder.star.setImageResource(R.drawable.star)
        }


    }

    override fun getItemCount(): Int {
        return emailList.size
    }
    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderName: TextView = itemView.findViewById(R.id.senderName)
        val emailSubject: TextView = itemView.findViewById(R.id.emailSubject)
        val senderImage: ImageView = itemView.findViewById(R.id.rv_user_image)
        val star:ImageView = itemView.findViewById(R.id.star)

        init {
            senderImage.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    if (position in selectedItems) {
                        selectedItems .remove(position)
                        emailList[position].selected = false
                        println(position)
                    } else {
                        selectedItems.add(position)
                        emailList[position].selected = true
                    }
                    notifyItemChanged(position)

                }
            }
            star.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    if (position in selectedStars) {
                        selectedStars.remove(position)
                        emailList[position].selectedStar = false
                    } else {
                        selectedStars.add(position)
                        emailList[position].selectedStar = true
                    }
                    notifyItemChanged(position)

                }
            }

        }
    }

//    private fun onItemClick(position: Int) {
//
//        notifyItemChanged(position)
//    }
}
