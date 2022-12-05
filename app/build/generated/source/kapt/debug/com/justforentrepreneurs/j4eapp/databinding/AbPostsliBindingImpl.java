package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AbPostsliBindingImpl extends AbPostsliBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ivProfileImg, 1);
        sViewsWithIds.put(R.id.fullname, 2);
        sViewsWithIds.put(R.id.datetime, 3);
        sViewsWithIds.put(R.id.cateimage, 4);
        sViewsWithIds.put(R.id.description, 5);
        sViewsWithIds.put(R.id.postimg, 6);
        sViewsWithIds.put(R.id.llComments, 7);
        sViewsWithIds.put(R.id.posttotalcomment, 8);
        sViewsWithIds.put(R.id.llLike, 9);
        sViewsWithIds.put(R.id.imagelike, 10);
        sViewsWithIds.put(R.id.totalike, 11);
        sViewsWithIds.put(R.id.llShare, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AbPostsliBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private AbPostsliBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[10]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[11]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
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