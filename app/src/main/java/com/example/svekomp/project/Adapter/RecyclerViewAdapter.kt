import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.svekomp.R
import com.example.svekomp.project.ui.Tasks.TaskDetail
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter(private var taskList: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var taskFilterList = ArrayList<String>()

    lateinit var mcontext: Context

    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        taskFilterList = taskList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val taskListView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        val search = TaskHolder(taskListView)
        mcontext = parent.context
        return search
    }

    override fun getItemCount(): Int {
        return taskFilterList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.select_task_text.text = taskFilterList[position]
        val test = R.id.rvhistorik
        holder.itemView.setOnClickListener {
            val intent = Intent(mcontext, TaskDetail::class.java)
            intent.putExtra("passselectedtask", taskFilterList[position])
            mcontext.startActivity(intent)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    taskFilterList = taskList
                } else {
                    val resultList = ArrayList<String>()
                    for (row in taskList) {
                        if (row.toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    taskFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = taskFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                taskFilterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }
}