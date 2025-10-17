package com.example.tokosidia.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.tokosidia.databinding.FragmentProductDetailBinding;
public class ProductDetailFragment extends Fragment {
    private FragmentProductDetailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        binding = FragmentProductDetailBinding.inflate(inflater, container,
                false);
        binding.tvDetailProduct.setText("Detail Produk Tokosidia"); // Contoh text sementara
        return binding.getRoot();
    }
}
