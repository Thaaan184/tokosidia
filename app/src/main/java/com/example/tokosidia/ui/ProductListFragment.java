package com.example.tokosidia.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.tokosidia.databinding.FragmentProductListBinding;
public class ProductListFragment extends Fragment {
    private FragmentProductListBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        binding = FragmentProductListBinding.inflate(inflater, container, false);
        binding.tvProductList.setText("Daftar Produk Tokosidia"); // Contoh text sementara
        return binding.getRoot();
    }
}