package com.example.tokosidia.ui;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.tokosidia.R;
import com.example.tokosidia.model.Product;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
// Fragment yang ditampilkan sebagai bottom sheet untuk menampilkan detail produk
public class ProductDetailFragment extends BottomSheetDialogFragment {
    // Menyimpan data produk dalam Bundle
    private static final String ARG_NAME = "name";
    private static final String ARG_PRICE = "price";
    private static final String ARG_DESC = "desc";
    private static final String ARG_RATING = "rating";
    private static final String ARG_IMAGE = "image";
    // Membuat instance fragment dengan data produk sebagai argumen
    public static ProductDetailFragment newInstance(Product product) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
// Menyimpan data produk ke dalam Bundle agar bisa diakses saat fragment dibuat
        args.putString(ARG_NAME, product.getName());
        args.putDouble(ARG_PRICE, product.getPrice());
        args.putString(ARG_DESC, product.getDescription());
        args.putFloat(ARG_RATING, product.getRating());
        args.putInt(ARG_IMAGE, product.getImageResId());
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
                             ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
// panggil layout XML untuk tampilan detail produk
        View view = inflater.inflate(R.layout.fragment_product_detail, container,
                false);
// Inisialisasi komponen UI dari layout
        ImageView imgProduct = view.findViewById(R.id.imgProduct);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtPrice = view.findViewById(R.id.txtPrice);
        TextView txtDesc = view.findViewById(R.id.txtDesc);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        Button btnBuy = view.findViewById(R.id.btnBuy);
// Mengambil data dari Bundle dan menampilkannya ke UI
        Bundle args = getArguments();
        if (args != null) {
            txtName.setText(args.getString(ARG_NAME));
            txtPrice.setText("Rp " + args.getDouble(ARG_PRICE));
            txtDesc.setText(args.getString(ARG_DESC));
            ratingBar.setRating(args.getFloat(ARG_RATING));
            imgProduct.setImageResource(args.getInt(ARG_IMAGE));
        }
// Menutup bottom sheet saat tombol "Beli" ditekan
        btnBuy.setOnClickListener(v -> dismiss());
        return view;
    }
}