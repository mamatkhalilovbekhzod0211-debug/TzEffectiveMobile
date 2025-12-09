package uz.bekhzod0211.tzeffectivemobile.presentation.main.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bekhzod0211.tzeffectivemobile.databinding.ItemCourseBinding
import uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.response.Course

class CourseAdapter(
    private val list: List<Course>
) : RecyclerView.Adapter<CourseAdapter.MyCourseHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCourseHolder {
        return MyCourseHolder(ItemCourseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )

    }

    override fun onBindViewHolder(
        holder: MyCourseHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class MyCourseHolder(private val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Course) {
            binding.apply {
                tvTitle.text = course.title
                tvPrice.text = course.price
                tvRating.text = course.rate
                tvDate.text = course.publishDate
                tvDescription.text = course.text

            }
        }
    }


}