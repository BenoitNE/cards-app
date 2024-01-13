import 'card.dart';
import 'package:json_annotation/json_annotation.dart';

part 'hand.g.dart';

@JsonSerializable()
class Hand {
  List<Card> cards;

  Hand(this.cards);

  factory Hand.fromJson(Map<String, dynamic> json) => _$HandFromJson(json);

  Map<String, dynamic> toJson() => _$HandToJson(this);
}