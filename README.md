# gradientimageview
GradientImageView is a imageview on which you can apply a gradient tint.

## Installation

Library is installed by putting aar file into libs folder:

```
module/libs (ex. app/libs)
```

and adding the aar dependency to your `build.gradle` file:
```groovy
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.0-alpha05'
    implementation 'androidx.core:core-ktx:1.8.0'
    implementation "org.mini2Dx:gdx-math:1.9.13"
    implementation files("libs/gradientimageview-1.0.0.aar")
}
```

## Screenshots
![](https://github.com/mgolebiowski95/gradientimageview/blob/master/screenshots/Screenshot_1659514222.png)

## Usage
```xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1"
    tools:context=".ui.main.MainFragment">

    <androidx.constraintlayout.helper.widget.Flow
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:constraint_referenced_ids="image_view,image_view_solid,image_view_3" />

    <com.mgsoftware.gradientimageview.widget.GradientImageView
        android:id="@+id/image_view"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:scaleType="centerInside"
        android:src="@drawable/white_circle"
        app:GradientImageView_colorList="@array/my_gradient"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintDimensionRatio="1:1"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintWidth_percent="0.5" />

    <com.mgsoftware.gradientimageview.widget.GradientImageView
        android:id="@+id/image_view_solid"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:scaleType="centerInside"
        android:src="@color/white"
        app:GradientImageView_colorList="@array/my_gradient"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintDimensionRatio="1:1"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintWidth_percent="0.5" />

    <com.mgsoftware.gradientimageview.widget.GradientImageView
        android:id="@+id/image_view_3"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:scaleType="centerInside"
        android:src="@drawable/ic_android_black_24dp"
        app:GradientImageView_colorList="@array/my_gradient"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintDimensionRatio="1:1"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintWidth_percent="0.5" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

### Attributes
| Attribute | Format | Default |
|:---|:---:|:---:|
| GradientImageView_colorList | reference |
