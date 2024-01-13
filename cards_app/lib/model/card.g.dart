// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'card.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Card _$CardFromJson(Map<String, dynamic> json) => Card(
      json['color'] as String,
      json['value'] as String,
      json['score'] as int,
    );

Map<String, dynamic> _$CardToJson(Card instance) => <String, dynamic>{
      'color': instance.color,
      'value': instance.value,
      'score': instance.score,
    };
