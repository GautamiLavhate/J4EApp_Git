package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BsCommentListBindingImpl extends BsCommentListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(1, 
            new String[] {"ab_commentsli", "ab_commentsli"},
            new int[] {2, 3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_commentsli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_commentsli});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text, 4);
        sViewsWithIds.put(R.id.ivClose, 5);
        sViewsWithIds.put(R.id.rvCommentList, 6);
        sViewsWithIds.put(R.id.linearlayout1, 7);
        sViewsWithIds.put(R.id.writeamsg, 8);
        sViewsWithIds.put(R.id.sendcommet, 9);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbCommentsliBinding mboundView11;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbCommentsliBinding mboundView12;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BsCommentListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private BsCommentListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[5]
            , (android.widget.LinearLayout) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[4]
            , (android.widget.EditText) bindings[8]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (com.justforentrepreneurs.j4eapp.databinding.AbCommentsliBinding) bindings[2];
        setContainedBinding(this.mboundView11);
        this.mboundView12 = (com.justforentrepreneurs.j4eapp.databinding.AbCommentsliBinding) bindings[3];
        setContainedBinding(this.mboundView12);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        mboundView11.invalidateAll();
        mboundView12.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView11.hasPendingBindings()) {
            return true;
        }
        if (mboundView12.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView11.setLifecycleOwner(lifecycleOwner);
        mboundView12.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView11);
        executeBindingsOn(mboundView12);
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