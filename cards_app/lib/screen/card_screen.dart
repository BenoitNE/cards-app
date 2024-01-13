import 'dart:convert';
import 'dart:developer';

import 'package:cards_app/model/card.dart';
import 'package:cards_app/service/card_http_service.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../model/hand.dart';
import '../util/dialog_util.dart';

class CardScreen extends StatefulWidget {
  const CardScreen({super.key});

  @override
  State<StatefulWidget> createState() => _CardScreenState();
}

class _CardScreenState extends State<CardScreen> {
  Hand? _hand;
  final CardHttpService _cardHttpService = CardHttpService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SingleChildScrollView(
            child: Column(children: [
      const SizedBox(height: 42.0),
      Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          ElevatedButton(
              onPressed: () {
                _getRandomCards();
              },
              child: const Text("Obtenir une main")),
          const SizedBox(width: 22.0),
          ElevatedButton(
              onPressed: () {
                _getFilteredCardsByValue();
              },
              child: const Text("Filtrer par valeur")),
          const SizedBox(width: 22.0),
          ElevatedButton(
              onPressed: () {
                _getFilteredCardsByColor();
              },
              child: const Text("Filtrer par couleur")),
        ],
      ),
      const SizedBox(height: 52.0),

      Container(
          alignment: Alignment.center,
          width: MediaQuery.of(context).size.width,
          height: 130.0,
          child: ListView.builder(
            physics: const ScrollPhysics(),
            shrinkWrap: true,
            itemCount: 10,
            scrollDirection: Axis.horizontal,
            itemBuilder: (context, index) {
              return Container(
                width: 75.0,
                margin: const EdgeInsets.all(12.0),
                padding: const EdgeInsets.all(4.0),
                decoration: BoxDecoration(
                    border: Border.all(color: Colors.black87),
                    borderRadius: BorderRadius.circular(8.0)),
                child: _hand == null ? null : Image.asset(_getCardPath(index)),
              );
            },
          ))
      // ListView.builder(itemBuilder: itemBuilder)
    ])));
  }

  bool _emptiedHand() {
    return _hand == null ? false : true;
  }

  Future<void> _getRandomCards() async {
    DialogUtil.launchWaitedSpin(context);
    await _cardHttpService.fetchRandomCards()?.then((value) {
      if (value.statusCode == 200) {
        _hand = Hand.fromJson(json.decode(value.body));
        setState(() {});
        Navigator.pop(context);
      } else {
        Navigator.pop(context);
        log(value.body);
        DialogUtil.launchError(context,
            "Une erreur est survenue, veuillez essayer ultérieurement.");
      }
    });
  }

  Future<void> _getFilteredCardsByValue() async {
    if (_emptiedHand()) {
      DialogUtil.launchWaitedSpin(context);

      await _cardHttpService.fetchFilteredCardsByValue(_hand!)?.then((value) {
        if (value.statusCode == 200) {
          _hand = Hand.fromJson(json.decode(value.body));
          setState(() {});
          Navigator.pop(context);
        } else {
          Navigator.pop(context);
          log(value.body);
          DialogUtil.launchError(context,
              "Une erreur est survenue, veuillez essayer ultérieurement.");
        }
      });
    } else {
      DialogUtil.launchError(context, "Aucune carte n'est sélectionnée.");
    }
  }

  Future<void> _getFilteredCardsByColor() async {
    if (_emptiedHand()) {
      DialogUtil.launchWaitedSpin(context);

      await _cardHttpService.fetchFilteredCardsByColor(_hand!)?.then((value) {
        if (value.statusCode == 200) {
          _hand = Hand.fromJson(json.decode(value.body));
          setState(() {});
          Navigator.pop(context);
        } else {
          Navigator.pop(context);
          log(value.body);
          DialogUtil.launchError(context,
              "Une erreur est survenue, veuillez essayer ultérieurement.");
        }
      });
    } else {
      DialogUtil.launchError(context, "Aucune carte n'est sélectionnée.");
    }
  }

  String _getCardPath(int index) {
    return "assets/cards/${_hand?.cards[index].value}-${_hand?.cards[index].color}.png";
  }
}
