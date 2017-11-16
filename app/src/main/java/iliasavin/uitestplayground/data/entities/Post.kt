package iliasavin.uitestplayground.data.entities

import android.os.Parcel
import android.os.Parcelable

data class Post(
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null,
    val userId: Int? = null
) : Parcelable {
  constructor(source: Parcel) : this(
      source.readValue(Int::class.java.classLoader) as Int?,
      source.readString(),
      source.readString(),
      source.readValue(Int::class.java.classLoader) as Int?
  )

  override fun describeContents() = 0

  override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
    writeValue(id)
    writeString(title)
    writeString(body)
    writeValue(userId)
  }

  companion object {
    @JvmField
    val CREATOR: Parcelable.Creator<Post> = object : Parcelable.Creator<Post> {
      override fun createFromParcel(source: Parcel): Post = Post(source)
      override fun newArray(size: Int): Array<Post?> = arrayOfNulls(size)
    }
  }
}
