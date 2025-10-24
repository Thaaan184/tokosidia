package com.example.tokosidia.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tokosidia.R;
import com.example.tokosidia.model.Product;
import com.example.tokosidia.ui.ProductDetailFragment;
import java.util.List;
// Menampilkan daftar produk dalam RecyclerView
public class ProductAdapter extends
        RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    // menentukan jenis tampilan item
    public static final int TYPE_LIST = 0; // Tampilan daftar
    public static final int TYPE_GRID = 1; // Tampilan grid
    public static final int TYPE_CARD = 2; // Tampilan kartu
    // Variabel konteks dan data produk
    private Context context;
    private List<Product> productList;
    // wow
    private int viewType; // Menentukan jenis layout yang digunakan
    // Menerima data dan jenis tampilan
    public ProductAdapter(Context context, List<Product> productList, int
            viewType) {
        this.context = context;
        this.productList = productList;
        this.viewType = viewType;
    }
    // Membuat ViewHolder sesuai dengan jenis tampilan yang dipilih
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        int layout;
// Menentukan layout berdasarkan tipe tampilan
        if (this.viewType == TYPE_GRID) {
            layout = R.layout.item_product_grid;
        } else if (this.viewType == TYPE_CARD) {
            layout = R.layout.item_product_card;
        } else {
            layout = R.layout.item_product_list;
        }
// Meng-inflate layout dan mengembalikan ViewHolder
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        return new ViewHolder(view);
    }
    // Binding data produk ke tampilan item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
// Menampilkan nama, harga, dan gambar produk
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText("Rp " + product.getPrice());
        holder.imgProduct.setImageResource(product.getImageResId());
// event handler item untuk menampilkan detail produk
        holder.itemView.setOnClickListener(v -> {
            ProductDetailFragment detailFragment =
                    ProductDetailFragment.newInstance(product);
            detailFragment.show(((androidx.fragment.app.FragmentActivity)
                    context)
                    .getSupportFragmentManager(), "ProductDetail");
        });
    }
    // return jumlah item dalam daftar produk
    @Override
    public int getItemCount() {
        return productList.size();
    }
    // Menyimpan referensi tampilan item
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice;
        ImageView imgProduct;
        // ViewHolder untuk menghubungkan tampilan dengan ID-nya
        ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            imgProduct = itemView.findViewById(R.id.imgProduct);
        }
    }
}