package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityAboutUsBindingImpl extends ActivityAboutUsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(14);
        sIncludes.setIncludes(0, 
            new String[] {"lay_toolbar"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar});
        sIncludes.setIncludes(1, 
            new String[] {"ab_aboutus"},
            new int[] {3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_aboutus});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 4);
        sViewsWithIds.put(R.id.vision, 5);
        sViewsWithIds.put(R.id.mission, 6);
        sViewsWithIds.put(R.id.value, 7);
        sViewsWithIds.put(R.id.email, 8);
        sViewsWithIds.put(R.id.numbermobile, 9);
        sViewsWithIds.put(R.id.whatsap, 10);
        sViewsWithIds.put(R.id.website, 11);
        sViewsWithIds.put(R.id.location, 12);
        sViewsWithIds.put(R.id.about, 13);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbAboutusBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAboutUsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityAboutUsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[8]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[9]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[10]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbAboutusBinding) bindings[3];
        setContainedBinding(this.mboundView1);
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
        mboundView1.invalidateAll();
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
        if (mboundView1.hasPendingBindings()) {
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
        mboundView1.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView1);
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