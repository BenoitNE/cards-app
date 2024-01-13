import 'package:json_annotation/json_annotation.dart';

part 'card.g.dart';

@JsonSerializable()
class Card {
  String color;
  String value;
  int score;

  Card(this.color, this.value, this.score);

  factory Card.fromJson(Map<String, dynamic> json) => _$CardFromJson(json);

  Map<String, dynamic> toJson() => _$CardToJson(this);

}