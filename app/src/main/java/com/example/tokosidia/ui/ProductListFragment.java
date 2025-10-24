package com.example.tokosidia.ui;

import android.os.Bundle;
import android.view.*;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosidia.R;
import com.example.tokosidia.adapter.ProductAdapter;
import com.example.tokosidia.model.Product;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment {
    // Deklarasi variabel UI dan data
    private RecyclerView recyclerView;
    private List<Product> productList;
    private int currentViewType = ProductAdapter.TYPE_LIST; // Default tampilan: list
    private Toolbar toolbar;

    // Konstruktor kosong (diperlukan oleh Fragment)
    public ProductListFragment() {
    }

    // Method untuk tampilan fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
// layout XML untuk fragment ini
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
// Inisialisasi komponen UI
        recyclerView = view.findViewById(R.id.recyclerView);
        toolbar = view.findViewById(R.id.toolbar);
// Set toolbar sebagai action bar
        ((androidx.appcompat.app.AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
// Mengaktifkan opsi menu di fragment
        setHasOptionsMenu(true);
// Inisialisasi data produk dan set tampilan awal
        initProducts();
        setRecycler(ProductAdapter.TYPE_LIST);
        return view;
    }

    // Mengisi daftar produk secara statis
    private void initProducts() {
        productList = new ArrayList<>();
// Menambahkan beberapa produk ke dalam list
        productList.add(new Product("Kemeja Polos", 150000, "Kemeja berbahan katun lembut.", 4.5f
                , R.drawable.kemeja));
        productList.add(new Product("Celana Jeans", 250000, "Celana jeans slim fit pria.", 4.2f,
                R.drawable.jeans));
        productList.add(new Product("Sepatu Sneakers", 350000, "Sepatu untuk aktivitas kasual.",
                4.8f, R.drawable.sepatu));
        productList.add(new Product("Jaket Hoodie", 275000, "Jaket hangat dengan bahan fleece.",
                4.6f, R.drawable.jaket));
        productList.add(new Product("Topi Denim", 95000, "Topi kasual berbahan denim.", 4.1f,
                R.drawable.topi));
        productList.add(new Product("Kemeja Polos", 150000, "Kemeja berbahan katun lembut.", 4.5f
                , R.drawable.kemeja));
        productList.add(new Product("Celana Jeans", 250000, "Celana jeans slim fit pria.", 4.2f,
                R.drawable.jeans));
        productList.add(new Product("Sepatu Sneakers", 350000, "Sepatu untuk aktivitas kasual.",
                4.8f,
                R.drawable.sepatu));
        productList.add(new Product("Jaket Hoodie", 275000, "Jaket hangat dengan bahan fleece.",
                4.6f,
                R.drawable.jaket));
        productList.add(new Product("Topi Denim", 95000, "Topi kasual berbahan denim.", 4.1f,
                R.drawable.topi));
    }

    // Mengatur tampilan RecyclerView berdasarkan tipe layout
    private void setRecycler(int viewType) {
        currentViewType = viewType;
        RecyclerView.LayoutManager layoutManager;
        // Gunakan GridLayoutManager jika tipe grid, jika tidak gunakan LinearLayoutManager
        if (viewType == ProductAdapter.TYPE_GRID) {
            layoutManager = new GridLayoutManager(getContext(), 2); // 2 kolom
        } else {
            layoutManager = new LinearLayoutManager(getContext()); // tampilan vertikal
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ProductAdapter(getContext(), productList,
                viewType));
    }
    // Membuat menu opsi di toolbar
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater
            inflater) {
        inflater.inflate(R.menu.menu_view_options, menu); // Inflate menu dari XML
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
// Tampilan berdasarkan item yang dipilih
        if (id == R.id.action_list) {
            setRecycler(ProductAdapter.TYPE_LIST);
            Toast.makeText(getContext(), "Tampilan List",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_grid) {
            setRecycler(ProductAdapter.TYPE_GRID);
            Toast.makeText(getContext(), "Tampilan Grid",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_card) {
            setRecycler(ProductAdapter.TYPE_CARD);
            Toast.makeText(getContext(), "Tampilan Card",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_filter) {
            showFilterDialog(); // Tampilkan dialog filter
        }
        return super.onOptionsItemSelected(item);
    }
    // Mmenampilkan dialog filter produk berdasarkan harga
    private void showFilterDialog() { String[] options = {"Harga < 200K", "Harga ≥ 200K", "Semua Produk"};
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Filter Produk")
                .setItems(options, (dialog, which) -> {
                    List<Product> filteredList = new ArrayList<>();
// Filter produk berdasarkan pilihan pengguna
                    switch (which) {
                        case 0:
                            for (Product p : productList) if (p.getPrice() <
                                    200000) filteredList.add(p);
                            break;
                        case 1:
                            for (Product p : productList) if (p.getPrice() >=
                                    200000) filteredList.add(p);
                            break;
                        default:
                            filteredList = new ArrayList<>(productList); // Semua produk
                    }
// Tampilkan hasil filter di RecyclerView
                    recyclerView.setAdapter(new ProductAdapter(getContext(),
                            filteredList, currentViewType));
                })
                .show();
    }
}