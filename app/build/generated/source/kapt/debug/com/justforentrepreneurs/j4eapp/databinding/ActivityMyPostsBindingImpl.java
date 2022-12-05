package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMyPostsBindingImpl extends ActivityMyPostsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(11);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar"},
            new int[] {3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar});
        sIncludes.setIncludes(2, 
            new String[] {"ab_postsli", "ab_postsli", "ab_postsli", "ab_postsli"},
            new int[] {4, 5, 6, 7},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_postsli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_postsli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_postsli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_postsli});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rvAllPosts, 8);
        sViewsWithIds.put(R.id.NoLeadInvited, 9);
        sViewsWithIds.put(R.id.default_text, 10);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding mboundView2;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding mboundView21;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding mboundView22;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding mboundView23;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyPostsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityMyPostsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.LinearLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding) bindings[3]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding) bindings[4];
        setContainedBinding(this.mboundView2);
        this.mboundView21 = (com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding) bindings[5];
        setContainedBinding(this.mboundView21);
        this.mboundView22 = (com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding) bindings[6];
        setContainedBinding(this.mboundView22);
        this.mboundView23 = (com.justforentrepreneurs.j4eapp.databinding.AbPostsliBinding) bindings[7];
        setContainedBinding(this.mboundView23);
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
        mboundView2.invalidateAll();
        mboundView21.invalidateAll();
        mboundView22.invalidateAll();
        mboundView23.invalidateAll();
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
        if (mboundView2.hasPendingBindings()) {
            return true;
        }
        if (mboundView21.hasPendingBindings()) {
            return true;
        }
        if (mboundView22.hasPendingBindings()) {
            return true;
        }
        if (mboundView23.hasPendingBindings()) {
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
        mboundView2.setLifecycleOwner(lifecycleOwner);
        mboundView21.setLifecycleOwner(lifecycleOwner);
        mboundView22.setLifecycleOwner(lifecycleOwner);
        mboundView23.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView2);
        executeBindingsOn(mboundView21);
        executeBindingsOn(mboundView22);
        executeBindingsOn(mboundView23);
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