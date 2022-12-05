package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProfileBindingImpl extends ActivityProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(31);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_editbtn"},
            new int[] {4},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_editbtn});
        sIncludes.setIncludes(2, 
            new String[] {"lay_profile_about_us", "lay_profile_contact_us", "lay_profile_gallery", "lay_profile_reviews"},
            new int[] {5, 6, 7, 8},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_profile_about_us,
                com.justforentrepreneurs.j4eapp.R.layout.lay_profile_contact_us,
                com.justforentrepreneurs.j4eapp.R.layout.lay_profile_gallery,
                com.justforentrepreneurs.j4eapp.R.layout.lay_profile_reviews});
        sIncludes.setIncludes(3, 
            new String[] {"ab_profilleview", "ab_profilecontactus"},
            new int[] {9, 10},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_profilleview,
                com.justforentrepreneurs.j4eapp.R.layout.ab_profilecontactus});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.llProfileInfo, 11);
        sViewsWithIds.put(R.id.ivProfileImg, 12);
        sViewsWithIds.put(R.id.userName, 13);
        sViewsWithIds.put(R.id.companyName, 14);
        sViewsWithIds.put(R.id.address, 15);
        sViewsWithIds.put(R.id.messageLL, 16);
        sViewsWithIds.put(R.id.messageimg, 17);
        sViewsWithIds.put(R.id.llFollow, 18);
        sViewsWithIds.put(R.id.llFollowst, 19);
        sViewsWithIds.put(R.id.ivStatusFollowing, 20);
        sViewsWithIds.put(R.id.llShare, 21);
        sViewsWithIds.put(R.id.llQrCode, 22);
        sViewsWithIds.put(R.id.llRewardPoint, 23);
        sViewsWithIds.put(R.id.rewardpoint, 24);
        sViewsWithIds.put(R.id.llRanks, 25);
        sViewsWithIds.put(R.id.rank, 26);
        sViewsWithIds.put(R.id.connections, 27);
        sViewsWithIds.put(R.id.baatch, 28);
        sViewsWithIds.put(R.id.tabProfile, 29);
        sViewsWithIds.put(R.id.fabAddGalleyImage, 30);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private ActivityProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7
            , (com.justforentrepreneurs.j4eapp.databinding.AbProfilecontactusBinding) bindings[10]
            , (com.justforentrepreneurs.j4eapp.databinding.AbProfilleviewBinding) bindings[9]
            , (android.widget.TextView) bindings[15]
            , (android.widget.ImageView) bindings[28]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[27]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[30]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[12]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.ImageView) bindings[17]
            , (com.justforentrepreneurs.j4eapp.databinding.LayProfileAboutUsBinding) bindings[5]
            , (com.justforentrepreneurs.j4eapp.databinding.LayProfileContactUsBinding) bindings[6]
            , (com.justforentrepreneurs.j4eapp.databinding.LayProfileGalleryBinding) bindings[7]
            , (com.justforentrepreneurs.j4eapp.databinding.LayProfileReviewsBinding) bindings[8]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[24]
            , (com.google.android.material.tabs.TabLayout) bindings[29]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding) bindings[4]
            , (android.widget.TextView) bindings[13]
            );
        setContainedBinding(this.abprofilecontactus);
        setContainedBinding(this.abprofilleview);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setContainedBinding(this.profileAboutUs);
        setContainedBinding(this.profileContactUs);
        setContainedBinding(this.profileGallery);
        setContainedBinding(this.profileReviews);
        this.profileview.setTag(null);
        this.profileview1.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
        }
        toolbar.invalidateAll();
        profileAboutUs.invalidateAll();
        profileContactUs.invalidateAll();
        profileGallery.invalidateAll();
        profileReviews.invalidateAll();
        abprofilleview.invalidateAll();
        abprofilecontactus.invalidateAll();
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
        if (profileAboutUs.hasPendingBindings()) {
            return true;
        }
        if (profileContactUs.hasPendingBindings()) {
            return true;
        }
        if (profileGallery.hasPendingBindings()) {
            return true;
        }
        if (profileReviews.hasPendingBindings()) {
            return true;
        }
        if (abprofilleview.hasPendingBindings()) {
            return true;
        }
        if (abprofilecontactus.hasPendingBindings()) {
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
        profileAboutUs.setLifecycleOwner(lifecycleOwner);
        profileContactUs.setLifecycleOwner(lifecycleOwner);
        profileGallery.setLifecycleOwner(lifecycleOwner);
        profileReviews.setLifecycleOwner(lifecycleOwner);
        abprofilleview.setLifecycleOwner(lifecycleOwner);
        abprofilecontactus.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBinding) object, fieldId);
            case 1 :
                return onChangeProfileReviews((com.justforentrepreneurs.j4eapp.databinding.LayProfileReviewsBinding) object, fieldId);
            case 2 :
                return onChangeProfileContactUs((com.justforentrepreneurs.j4eapp.databinding.LayProfileContactUsBinding) object, fieldId);
            case 3 :
                return onChangeAbprofilleview((com.justforentrepreneurs.j4eapp.databinding.AbProfilleviewBinding) object, fieldId);
            case 4 :
                return onChangeAbprofilecontactus((com.justforentrepreneurs.j4eapp.databinding.AbProfilecontactusBinding) object, fieldId);
            case 5 :
                return onChangeProfileGallery((com.justforentrepreneurs.j4eapp.databinding.LayProfileGalleryBinding) object, fieldId);
            case 6 :
                return onChangeProfileAboutUs((com.justforentrepreneurs.j4eapp.databinding.LayProfileAboutUsBinding) object, fieldId);
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
    private boolean onChangeProfileReviews(com.justforentrepreneurs.j4eapp.databinding.LayProfileReviewsBinding ProfileReviews, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeProfileContactUs(com.justforentrepreneurs.j4eapp.databinding.LayProfileContactUsBinding ProfileContactUs, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeAbprofilleview(com.justforentrepreneurs.j4eapp.databinding.AbProfilleviewBinding Abprofilleview, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeAbprofilecontactus(com.justforentrepreneurs.j4eapp.databinding.AbProfilecontactusBinding Abprofilecontactus, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeProfileGallery(com.justforentrepreneurs.j4eapp.databinding.LayProfileGalleryBinding ProfileGallery, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeProfileAboutUs(com.justforentrepreneurs.j4eapp.databinding.LayProfileAboutUsBinding ProfileAboutUs, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
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
        executeBindingsOn(profileAboutUs);
        executeBindingsOn(profileContactUs);
        executeBindingsOn(profileGallery);
        executeBindingsOn(profileReviews);
        executeBindingsOn(abprofilleview);
        executeBindingsOn(abprofilecontactus);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): profileReviews
        flag 2 (0x3L): profileContactUs
        flag 3 (0x4L): abprofilleview
        flag 4 (0x5L): abprofilecontactus
        flag 5 (0x6L): profileGallery
        flag 6 (0x7L): profileAboutUs
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}