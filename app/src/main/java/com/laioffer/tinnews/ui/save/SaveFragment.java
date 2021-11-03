package com.laioffer.tinnews.ui.save;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.FragmentSaveBinding;
import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.repository.NewsRepository;
import com.laioffer.tinnews.repository.NewsViewModelFactory;

import java.util.List;

public class SaveFragment extends Fragment {

    private FragmentSaveBinding binding;
    private SaveViewModel viewModel;
    private SavedNewsAdapter savedNewsAdapter;

    public SaveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSaveBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedNewsAdapter == null) {
            savedNewsAdapter = new SavedNewsAdapter();
        }

        savedNewsAdapter.setItemCallBack(new SavedNewsAdapter.ItemCallback() {
            @Override
            public void onOpenDetails(Article article) {
                SaveFragmentDirections.ActionNavigationSaveToNavigationDetails
                        direction = SaveFragmentDirections.actionNavigationSaveToNavigationDetails(article);
                NavHostFragment.findNavController(SaveFragment.this).navigate((NavDirections) direction);
            }

            @Override
            public void onRemoveFavorite(Article article) {
                viewModel.deleteSavedArticle(article);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        binding.newsSavedRecyclerView.setLayoutManager(linearLayoutManager);
        binding.newsSavedRecyclerView.setAdapter(savedNewsAdapter);

        NewsRepository newsRepository = new NewsRepository();
        viewModel = new ViewModelProvider(this,
                new NewsViewModelFactory(newsRepository)).get(SaveViewModel.class);

        viewModel.getAllSavedArticles().observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                if (articles != null) {
                    Log.d("SaveFragment", articles.toString());
                    savedNewsAdapter.setArticles(articles);
                }
            }
        });
    }

}