package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRecommendedLeadBindingImpl extends ActivityRecommendedLeadBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(11);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.searchLinLay, 3);
        sViewsWithIds.put(R.id.editsearchname, 4);
        sViewsWithIds.put(R.id.noteTextview, 5);
        sViewsWithIds.put(R.id.rvAllBuddies, 6);
        sViewsWithIds.put(R.id.NoLeadInvited, 7);
        sViewsWithIds.put(R.id.default_text, 8);
        sViewsWithIds.put(R.id.next_btd, 9);
        sViewsWithIds.put(R.id.leaddeatis1, 10);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRecommendedLeadBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityRecommendedLeadBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.EditText) bindings[4]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (android.widget.LinearLayout) bindings[3]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding) bindings[2]
            );
        this.lib.setTag(null);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        toolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbar.hasPendingBindings()) {
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
        toolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}