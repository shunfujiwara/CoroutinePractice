package jp.shn.coroutine.practice.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import jp.shn.coroutine.practice.R
import jp.shn.coroutine.practice.databinding.FragmentArticleListBinding
import jp.shn.coroutine.practice.ui.adapter.ArticleListAdapter
import jp.shn.coroutine.practice.ui.viewmodel.ArticleListViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ArticleListFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: ArticleListViewModel

    lateinit var binding: FragmentArticleListBinding
    lateinit var adapter: ArticleListAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_ArticleListFragment_to_SecondFragment)
//        }
        binding = FragmentArticleListBinding.bind(view)
        viewInit()
        viewModel.start(lifecycleScope)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    private fun viewInit() {
        adapter = ArticleListAdapter(context, viewModel.articles)
        val lm = androidx.recyclerview.widget.LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = lm
        val  divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(divider)
        binding.recyclerView.adapter = adapter
    }
}