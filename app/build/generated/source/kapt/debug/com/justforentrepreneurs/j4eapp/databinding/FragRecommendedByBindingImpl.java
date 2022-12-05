package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragRecommendedByBindingImpl extends FragRecommendedByBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(19);
        sIncludes.setIncludes(1, 
            new String[] {"ab_recommendedbyl", "ab_recommendedbyl", "ab_recommendedbyl", "ab_recommendedbyl", "ab_recommendedbyl", "ab_recommendedbyl", "ab_recommendedbyl", "ab_recommendedbyl"},
            new int[] {2, 3, 4, 5, 6, 7, 8, 9},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl,
                com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl,
                com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl,
                com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl,
                com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl,
                com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl,
                com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl,
                com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.searchli, 10);
        sViewsWithIds.put(R.id.editsearchname, 11);
        sViewsWithIds.put(R.id.rvRecommended, 12);
        sViewsWithIds.put(R.id.NoGuestInvited, 13);
        sViewsWithIds.put(R.id.defaultText, 14);
        sViewsWithIds.put(R.id.fabFilter, 15);
        sViewsWithIds.put(R.id.fabSort, 16);
        sViewsWithIds.put(R.id.fabSearch, 17);
        sViewsWithIds.put(R.id.fabclose, 18);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView11;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView12;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView13;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView14;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView15;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView16;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding mboundView17;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragRecommendedByBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragRecommendedByBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.EditText) bindings[11]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[15]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[17]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[16]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[10]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[2];
        setContainedBinding(this.mboundView1);
        this.mboundView11 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[3];
        setContainedBinding(this.mboundView11);
        this.mboundView12 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[4];
        setContainedBinding(this.mboundView12);
        this.mboundView13 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[5];
        setContainedBinding(this.mboundView13);
        this.mboundView14 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[6];
        setContainedBinding(this.mboundView14);
        this.mboundView15 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[7];
        setContainedBinding(this.mboundView15);
        this.mboundView16 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[8];
        setContainedBinding(this.mboundView16);
        this.mboundView17 = (com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBinding) bindings[9];
        setContainedBinding(this.mboundView17);
        this.rvRecommendedlist.setTag(null);
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