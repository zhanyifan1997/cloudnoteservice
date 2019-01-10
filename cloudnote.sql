/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : cloudnote

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 10/01/2019 19:14:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (16, '*', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83er8pEMibjoKicXyW6HyicoXnEpYXkJ0CTKaUIkLtZgATNsNlnOtCy39dWib1mYZtU1m3ZPf7jBscjTI8g/132', 'smartmesh', '0x095fd3415706990146d78c3b3c4e5235311d93c312ebd44b8e05c0d5f657b7fb');
INSERT INTO `note` VALUES (17, '*', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83er8pEMibjoKicXyW6HyicoXnEpYXkJ0CTKaUIkLtZgATNsNlnOtCy39dWib1mYZtU1m3ZPf7jBscjTI8g/132', 'smartmesh云笔记', '0xa5581fbd7911596f3e703a796964f9cdd86c1975f82430c97c9ba639fbba3377');
INSERT INTO `note` VALUES (18, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (19, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (20, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (21, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (22, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (23, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (24, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (25, '*', '1.png', 'hello', '123');
INSERT INTO `note` VALUES (26, '*', '1.png', 'hello', '123');

SET FOREIGN_KEY_CHECKS = 1;
