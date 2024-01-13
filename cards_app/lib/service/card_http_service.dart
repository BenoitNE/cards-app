import 'dart:convert';

import 'package:http/http.dart' as http;

import '../model/hand.dart';

class CardHttpService {
  final String _baseUrl = "http://145.14.158.114:8383/cards-app";
  final String _geRandomCardsEndPoint = "/random-cards";
  final String _getFilteredCardsByColor = "/cards-by-color";
  final String _getFilteredCardsByValue = "/cards-by-value";
  final Map <String, String> _headers = {"Content-Type": "application/json; charset=UTF-8"};

  Future<http.Response>? fetchRandomCards() {
    return http.get(Uri.parse(_baseUrl + _geRandomCardsEndPoint));
  }

  Future<http.Response>? fetchFilteredCardsByColor(Hand hand) {
    return http.post(Uri.parse(_baseUrl + _getFilteredCardsByColor),
        headers: _headers,
        body: json.encode(hand.toJson()));
  }

  Future<http.Response>? fetchFilteredCardsByValue(Hand hand) {
    return http.post(Uri.parse(_baseUrl + _getFilteredCardsByValue),
        headers: _headers,
        body: json.encode(hand.toJson()));
  }
}


