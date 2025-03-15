package raisetech.student.management.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Schema(description = "受講生情報")
@Getter
@Setter
public class Student {

  @Schema(description = "ID。自動連番で付与", example = "1")
  private int id;

  @Schema(description = "受講生氏名", example = "山田 太郎")
  @NotBlank(message = "入力が必要です")
  private String name;

  @Schema(description = "フリガナ。カタカナと全角、半角スペースのみ許可", example = "ヤマダ タロウ")
  @NotBlank(message = "入力が必要です")
  private String kanaName;

  @Schema(description = "ニックネーム", example = "タロー")
  private String nickname;

  @Schema(description = "メールアドレス", example = "taro@example.com")
  @NotBlank(message = "入力が必要です")
  @Email(message = "メールアドレスの形式が誤っています")
  private String email;

  @Schema(description = "居住地域。都道府県＋市区町村までを想定", example = "沖縄県那覇市")
  private String area;

  @Schema(description = "年齢。0~150までを許可", example = "30")
  @Range(min = 0, max = 150, message = "正しい値を入力してください")
  private int age;

  @Schema(description = "性別", example = "男性")
  private String sex;

  @Schema(description = "備考", example = "転職活動中")
  private String remark;
  
  @Schema(description = "削除フラグ", example = "false")
  private boolean isDeleted;

}
