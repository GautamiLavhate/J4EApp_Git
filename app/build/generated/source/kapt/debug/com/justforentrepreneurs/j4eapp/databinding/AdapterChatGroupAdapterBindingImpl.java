package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AdapterChatGroupAdapterBindingImpl extends AdapterChatGroupAdapterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_name, 1);
        sViewsWithIds.put(R.id.count_unread_badge, 2);
        sViewsWithIds.put(R.id.time_chats, 3);
        sViewsWithIds.put(R.id.user_photo, 4);
        sViewsWithIds.put(R.id.membertotal, 5);
        sViewsWithIds.put(R.id.img_read_tag_chats, 6);
        sViewsWithIds.put(R.id.tv_last_message, 7);
        sViewsWithIds.put(R.id.tv_typing_stat, 8);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AdapterChatGroupAdapterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private AdapterChatGroupAdapterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (com.aghajari.emojiview.view.AXEmojiTextView) bindings[7]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[8]
            , (android.widget.ImageView) bindings[4]
            );
        this.containerLayout.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}