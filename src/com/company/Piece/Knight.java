package com.company.Piece;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knight extends Piece{

    private final static int[] CANDIDATE_MOVE_COORDINATE = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(final int piecePosition,final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }
    @Override
    public List<Move> calculateLegalMoves(Board board) {

        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        for(final int currentCandidate : CANDIDATE_MOVE_COORDINATE){
            candidateDestinationCoordinate = this.piecePosition + currentCandidate;
            if(true){

                final Tile candidateDestiantionTile = board.getTile(candidateDestinationCoordinate);

                if(!candidateDestiantionTile.isTileOccupied()){
                    legalMoves.add(new Move());
                }else{
                    final Piece pieceAtDestination = candidateDestiantionTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                    if(this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return legalMoves;
    }
}
