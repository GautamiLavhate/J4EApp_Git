package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEventJoinerBindingImpl extends ActivityEventJoinerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(14);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_simple"},
            new int[] {1},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.toolbar_simple});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.searchLinLay, 2);
        sViewsWithIds.put(R.id.backgroundView, 3);
        sViewsWithIds.put(R.id.recyclerView, 4);
        sViewsWithIds.put(R.id.NoLeadInvited, 5);
        sViewsWithIds.put(R.id.default_text, 6);
        sViewsWithIds.put(R.id.linearlayout1, 7);
        sViewsWithIds.put(R.id.userImage, 8);
        sViewsWithIds.put(R.id.userName, 9);
        sViewsWithIds.put(R.id.designation, 10);
        sViewsWithIds.put(R.id.lib, 11);
        sViewsWithIds.put(R.id.imageViewLinLay, 12);
        sViewsWithIds.put(R.id.connectedLabel, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEventJoinerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityEventJoinerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[5]
            , (android.view.View) bindings[3]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (android.widget.SearchView) bindings[2]
            , (com.justforentrepreneurs.j4eapp.databinding.ToolbarSimpleBinding) bindings[1]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[8]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.ToolbarSimpleBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.ToolbarSimpleBinding Toolbar, int fieldId) {
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