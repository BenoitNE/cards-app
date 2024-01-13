// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'hand.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Hand _$HandFromJson(Map<String, dynamic> json) => Hand(
      (json['cards'] as List<dynamic>)
          .map((e) => Card.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$HandToJson(Hand instance) => <String, dynamic>{
      'cards': instance.cards,
    };
