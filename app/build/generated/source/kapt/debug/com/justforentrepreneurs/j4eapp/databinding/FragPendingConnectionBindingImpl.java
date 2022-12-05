package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragPendingConnectionBindingImpl extends FragPendingConnectionBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(16);
        sIncludes.setIncludes(1, 
            new String[] {"ab_connectionli", "ab_connectionli", "ab_connectionli", "ab_connectionli", "ab_connectionli", "ab_connectionli", "ab_connectionli", "ab_connectionli", "ab_connectionli", "ab_connectionli"},
            new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rvRequirement, 12);
        sViewsWithIds.put(R.id.NoLeadInvited, 13);
        sViewsWithIds.put(R.id.imagevno, 14);
        sViewsWithIds.put(R.id.default_text, 15);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView11;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView12;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView13;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView14;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView15;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView16;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView17;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView18;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding mboundView19;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragPendingConnectionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private FragPendingConnectionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[2];
        setContainedBinding(this.mboundView1);
        this.mboundView11 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[3];
        setContainedBinding(this.mboundView11);
        this.mboundView12 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[4];
        setContainedBinding(this.mboundView12);
        this.mboundView13 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[5];
        setContainedBinding(this.mboundView13);
        this.mboundView14 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[6];
        setContainedBinding(this.mboundView14);
        this.mboundView15 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[7];
        setContainedBinding(this.mboundView15);
        this.mboundView16 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[8];
        setContainedBinding(this.mboundView16);
        this.mboundView17 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[9];
        setContainedBinding(this.mboundView17);
        this.mboundView18 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[10];
        setContainedBinding(this.mboundView18);
        this.mboundView19 = (com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBinding) bindings[11];
        setContainedBinding(this.mboundView19);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        mboundView1.invalidateAll();
        mboundView11.invalidateAll();
        mboundView12.invalidateAll();
        mboundView13.invalidateAll();
        mboundView14.invalidateAll();
        mboundView15.invalidateAll();
        mboundView16.invalidateAll();
        mboundView17.invalidateAll();
        mboundView18.invalidateAll();
        mboundView19.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView1.hasPendingBindings()) {
            return true;
        }
        if (mboundView11.hasPendingBindings()) {
            return true;
        }
        if (mboundView12.hasPendingBindings()) {
            return true;
        }
        if (mboundView13.hasPendingBindings()) {
            return true;
        }
        if (mboundView14.hasPendingBindings()) {
            return true;
        }
        if (mboundView15.hasPendingBindings()) {
            return true;
        }
        if (mboundView16.hasPendingBindings()) {
            return true;
        }
        if (mboundView17.hasPendingBindings()) {
            return true;
        }
        if (mboundView18.hasPendingBindings()) {
            return true;
        }
        if (mboundView19.hasPendingBindings()) {
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
        mboundView1.setLifecycleOwner(lifecycleOwner);
        mboundView11.setLifecycleOwner(lifecycleOwner);
        mboundView12.setLifecycleOwner(lifecycleOwner);
        mboundView13.setLifecycleOwner(lifecycleOwner);
        mboundView14.setLifecycleOwner(lifecycleOwner);
        mboundView15.setLifecycleOwner(lifecycleOwner);
        mboundView16.setLifecycleOwner(lifecycleOwner);
        mboundView17.setLifecycleOwner(lifecycleOwner);
        mboundView18.setLifecycleOwner(lifecycleOwner);
        mboundView19.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView1);
        executeBindingsOn(mboundView11);
        executeBindingsOn(mboundView12);
        executeBindingsOn(mboundView13);
        executeBindingsOn(mboundView14);
        executeBindingsOn(mboundView15);
        executeBindingsOn(mboundView16);
        executeBindingsOn(mboundView17);
        executeBindingsOn(mboundView18);
        executeBindingsOn(mboundView19);
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