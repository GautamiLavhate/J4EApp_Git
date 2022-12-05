package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProfileContactUsEditBindingImpl extends ActivityProfileContactUsEditBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(48);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_editbtn"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_editbtn});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.llProfileInfo, 3);
        sViewsWithIds.put(R.id.ivProfileImg, 4);
        sViewsWithIds.put(R.id.imageadd, 5);
        sViewsWithIds.put(R.id.fullname, 6);
        sViewsWithIds.put(R.id.companyNameti, 7);
        sViewsWithIds.put(R.id.address, 8);
        sViewsWithIds.put(R.id.fullname1, 9);
        sViewsWithIds.put(R.id.llGender, 10);
        sViewsWithIds.put(R.id.edtGen, 11);
        sViewsWithIds.put(R.id.crossfunGen, 12);
        sViewsWithIds.put(R.id.ivDropDownGen, 13);
        sViewsWithIds.put(R.id.ivDropUpGen, 14);
        sViewsWithIds.put(R.id.rvGen, 15);
        sViewsWithIds.put(R.id.spGender, 16);
        sViewsWithIds.put(R.id.contactemail, 17);
        sViewsWithIds.put(R.id.phonenumber, 18);
        sViewsWithIds.put(R.id.edtWhatsapp, 19);
        sViewsWithIds.put(R.id.edtWhatsappBusiness, 20);
        sViewsWithIds.put(R.id.companyName, 21);
        sViewsWithIds.put(R.id.designation, 22);
        sViewsWithIds.put(R.id.totalexperiiace, 23);
        sViewsWithIds.put(R.id.llCategorySelection, 24);
        sViewsWithIds.put(R.id.tvCategory, 25);
        sViewsWithIds.put(R.id.crossfun, 26);
        sViewsWithIds.put(R.id.ivDropDown, 27);
        sViewsWithIds.put(R.id.ivDropUp, 28);
        sViewsWithIds.put(R.id.rvCategory, 29);
        sViewsWithIds.put(R.id.website, 30);
        sViewsWithIds.put(R.id.location, 31);
        sViewsWithIds.put(R.id.dobedt, 32);
        sViewsWithIds.put(R.id.crossfunDateOfBirth, 33);
        sViewsWithIds.put(R.id.Google, 34);
        sViewsWithIds.put(R.id.Facebooklink, 35);
        sViewsWithIds.put(R.id.linkedintwo, 36);
        sViewsWithIds.put(R.id.ivImgAddfont, 37);
        sViewsWithIds.put(R.id.relativelayoutvCardFront, 38);
        sViewsWithIds.put(R.id.imgvcardfront1, 39);
        sViewsWithIds.put(R.id.iveditfront1, 40);
        sViewsWithIds.put(R.id.ivdeletefront1, 41);
        sViewsWithIds.put(R.id.ivImgAddBack, 42);
        sViewsWithIds.put(R.id.relativelayoutvCardBack, 43);
        sViewsWithIds.put(R.id.imgvcardback2, 44);
        sViewsWithIds.put(R.id.iveditback2, 45);
        sViewsWithIds.put(R.id.ivdeleteback2, 46);
        sViewsWithIds.put(R.id.editcontact1, 47);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileContactUsEditBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 48, sIncludes, sViewsWithIds));
    }
    private ActivityProfileContactUsEditBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.EditText) bindings[35]
            , (android.widget.EditText) bindings[34]
            , (android.widget.TextView) bindings[8]
            , (android.widget.EditText) bindings[21]
            , (android.widget.TextView) bindings[7]
            , (android.widget.EditText) bindings[17]
            , (android.widget.ImageView) bindings[26]
            , (android.widget.ImageView) bindings[33]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.EditText) bindings[22]
            , (android.widget.TextView) bindings[32]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[47]
            , (android.widget.TextView) bindings[11]
            , (android.widget.EditText) bindings[19]
            , (android.widget.EditText) bindings[20]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[44]
            , (android.widget.ImageView) bindings[39]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[28]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[42]
            , (android.widget.ImageView) bindings[37]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (android.widget.ImageView) bindings[46]
            , (android.widget.ImageView) bindings[41]
            , (android.widget.ImageView) bindings[45]
            , (android.widget.ImageView) bindings[40]
            , (android.widget.EditText) bindings[36]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.EditText) bindings[31]
            , (android.widget.EditText) bindings[18]
            , (android.widget.RelativeLayout) bindings[43]
            , (android.widget.RelativeLayout) bindings[38]
            , (androidx.recyclerview.widget.RecyclerView) bindings[29]
            , (androidx.recyclerview.widget.RecyclerView) bindings[15]
            , (android.widget.Spinner) bindings[16]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding) bindings[2]
            , (android.widget.EditText) bindings[23]
            , (android.widget.EditText) bindings[25]
            , (android.widget.EditText) bindings[30]
            );
        this.editcontact.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
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
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding Toolbar, int fieldId) {
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