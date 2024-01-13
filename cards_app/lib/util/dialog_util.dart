import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';

class DialogUtil{

  static const String _errorImagePath = "assets/error_drawing.png";

  static void launchWaitedSpin(BuildContext context) => showDialog<String>(
      context: context,
      builder: (BuildContext context) => AlertDialog(
          backgroundColor: Colors.transparent,
          elevation: 0,
          content: Center(
            child: Container(
                width: 80.0,
                height: 80.0,
                color: Colors.transparent,
                child: const SpinKitChasingDots(color: Colors.white, size: 42)),
          )));

  static void launchError(BuildContext context, String message) =>
      showDialog<String>(
          context: context,
          builder: (BuildContext context) => AlertDialog(
            title: SizedBox(
              height: 100,
              child: Image.asset(_errorImagePath),
            ),
            content: SizedBox(
                width: 66,
                child: Text(message)),
            actions: <Widget>[
              TextButton(
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: const Text(
                  'Retour',
                  style: TextStyle(fontWeight: FontWeight.bold),
                ),
              ),
            ],
          ));
}