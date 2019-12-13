package com.utecht;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day03{
	public enum DIRECTION {
		R, D, L, U
	}
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Day03.class);
	final List<List<Walk>> paths = new ArrayList<List<Walk>>();
	final EnumMap<DIRECTION, int[]> map = initMap();
	
	public Day03(final File file){
		final Scanner sc = Utils.getScanner(file);
		while(sc.hasNextLine()){
			paths.add(convertToWalks(sc.nextLine().split(",")));
		}
	}
	
	protected int part01(){
		final List<List<Point>> sets = findPoints();
		//LOGGER.info("setsPart01: {}", sets);
		//find intersections
		final List<Point> intersections = new LinkedList<Point>();
		intersections.addAll(sets.get(0));
		for(final List<Point> set : sets){
			intersections.retainAll(set);
		}
		//LOGGER.debug("intersections: {}", intersections);
		//find min distance
		int[] distances = new int[intersections.size()];
		int count = 0;
		for(final Point point : intersections){
			distances[count] = ((Math.abs(point.x) + Math.abs(point.y)));
			count++;
		}
		return Arrays.stream(distances).min().getAsInt();
	}
	
	protected int part02(){
		final List<List<Point>> sets = findPoints();
		//LOGGER.info("setsPart02: {}", sets);
		//find intersections
		final List<Point> intersections = new LinkedList<Point>();
		intersections.addAll(sets.get(0));
		for(final List<Point> set : sets){
			intersections.retainAll(set);
		}
		//LOGGER.debug("intersections: {}", intersections);
		//find least steps
		int[] leastSteps = new int[intersections.size()];
		int count = 0;
		for(final Point point : intersections) {
			int sumSteps = 0;
			for(final List<Point> set : sets) {
				int idx = set.indexOf(point);
				//LOGGER.info("set: {}", set);
				//LOGGER.info("idx of point({},{}): {}", point.x, point.y, idx);
				sumSteps += idx + 1;
			}
			leastSteps[count] = sumSteps;
			count++;
		}
		//LOGGER.info("{}", leastSteps);
		return Arrays.stream(leastSteps).min().getAsInt();
	}
	
	protected List<List<Point>> findPoints(){
		final List<List<Point>> sets = new LinkedList<List<Point>>();
		for(final List<Walk> path : paths){
			//LOGGER.debug("path: {}", path);
			List<Point> points = new LinkedList<Point>();
			int x = 0;
			int y = 0;
			for(final Walk walk : path){
				//LOGGER.debug("{}", walk);
				int xChange = map.get(DIRECTION.valueOf(walk.direction))[0];
				int yChange = map.get(DIRECTION.valueOf(walk.direction))[1];
				for(int i = 0; i < walk.steps; i++){
					x += xChange;
					y += yChange;
					points.add(new Point(x, y));
				}
			}
			//LOGGER.debug("points: {}", points);
			sets.add(points);
		}
		return sets;
	}
	
	protected EnumMap<DIRECTION, int[]> initMap(){
		EnumMap<DIRECTION, int[]> directionMap = new EnumMap<DIRECTION, int[]>(DIRECTION.class);
		directionMap.put(DIRECTION.R, new int[]{1, 0});
		directionMap.put(DIRECTION.D, new int[]{0, -1});
		directionMap.put(DIRECTION.L, new int[]{-1, 0});
		directionMap.put(DIRECTION.U, new int[]{0, 1});
		return directionMap;
	}
	
	protected List<Walk> convertToWalks(String[] path){
		List<Walk> pathInWalks = new ArrayList<Walk>();
		for(final String walk : path){
			pathInWalks
				.add(new Walk(walk.substring(0, 1), Integer.parseInt(walk.substring(1, walk.length()))));
		}
		return pathInWalks;
	}
	
	protected class Walk{
		final String direction;
		final int steps;
		
		public Walk(final String s, final int num){
			direction = s;
			steps = num;
		}
		
		@Override
		public String toString(){
			return String.format("('%s', %d)", direction, steps);
		}
	}
}
