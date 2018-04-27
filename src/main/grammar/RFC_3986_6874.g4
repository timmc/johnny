grammar RFC_3986_6874;

// RFC 3986: Uniform Resource Identifier
//
// Appendix A: Collected ABNF for URI
//
// Retrieved 2018-04-25 from <https://tools.ietf.org/html/rfc3986#appendix-A>

uri           : scheme COLON hier_part ( QUESTION query )? ( POUND fragment_1 )?;

hier_part     : ((SLASH SLASH) authority path_abempty)
              | path_absolute
              | path_rootless
              | path_empty;

scheme        : alpha ( alpha | digit | PLUS | DASH | PERIOD )*;

authority     : ( userinfo AT )? host ( COLON port )?;
userinfo      : ( unreserved | pct_encoded | sub_delims | COLON )*;
host          : ip_literal | ipv4address | reg_name;
port          : digit*;

ipvfuture     : (CAP_V | V) hexdig+ PERIOD ( unreserved | sub_delims | COLON )+;

ipv6address   :                            (( h16 COLON ) (h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON) ls32)
              |                       ((COLON COLON) ( h16 COLON ) (h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON) ls32)
              | ((               h16 )? (COLON COLON) ( h16 COLON ) (h16 COLON) (h16 COLON) (h16 COLON) ls32)
              | ((  (( h16 COLON )?) h16 )? (COLON COLON) ( h16 COLON ) (h16 COLON) (h16 COLON) ls32)
              | ((  (( h16 COLON )? | ((h16 COLON) (h16 COLON))) h16 )? (COLON COLON) ( h16 COLON ) (h16 COLON) ls32)
              | ((  (( h16 COLON )? | ((h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON))) h16 )? (COLON COLON)    h16 COLON   ls32)
              | ((  (( h16 COLON )? | ((h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON))) h16 )? (COLON COLON)              ls32)
              | ((  (( h16 COLON )? | ((h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON))) h16 )? (COLON COLON)              h16)
              | ((  (( h16 COLON )? | ((h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON)) | ((h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON) (h16 COLON))) h16 )? (COLON COLON));

h16           : hexdig (hexdig? | (hexdig hexdig) | (hexdig hexdig hexdig));
ls32          : ( h16 COLON h16 ) | ipv4address;
ipv4address   : dec_octet PERIOD dec_octet PERIOD dec_octet PERIOD dec_octet;

dec_octet     : digit                 // 0-9
              | ((ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN | EIGHT | NINE) digit)         // 10-99
              | (ONE digit digit)            // 100-199
              | (TWO (ZERO | ONE | TWO | THREE | FOUR) digit)     // 200-249
              | ((TWO FIVE) (ZERO | ONE | TWO | THREE | FOUR | FIVE));          // 250-255

reg_name      : ( unreserved | pct_encoded | sub_delims )*;

path_abempty  : ( SLASH segment )*;
path_absolute : SLASH ( segment_nz ( SLASH segment )* )?;
path_rootless : segment_nz ( SLASH segment )*;
path_empty    : ;

segment       : pchar*;
segment_nz    : pchar+;

pchar         : unreserved | pct_encoded | sub_delims | COLON | AT;

query         : ( pchar | SLASH | QUESTION )*;

fragment_1      : ( pchar | SLASH | QUESTION )*;

pct_encoded   : PERCENT hexdig hexdig;

unreserved    : alpha | digit | DASH | PERIOD | UNDERSCORE | TILDE;
sub_delims    : EXCLAMATION | DOLLAR | AMPERSAND | APOSTROPHE | LEFT_PAREN | RIGHT_PAREN
              | ASTERISK | PLUS | COMMA | SEMICOLON | EQUALS;

// RFC 6874: Representing IPv6 Zone Identifiers in Address Literals and Uniform Resource Identifiers
//
// Chapter 6: Specification
//
// Retrieved 2018-04-26 from <https://tools.ietf.org/html/rfc6874#page-4>

ip_literal : LEFT_BRACE ( ipv6address | ipv6addrz | ipvfuture  ) RIGHT_BRACE;

zoneid : ( unreserved | pct_encoded )+;

ipv6addrz : ipv6address (PERCENT TWO FIVE) zoneid;

// RFC 5234: Augmented BNF for Syntax Specifications: ABNF
//
// Appendix B.1: Core Rules
//
// Retrieved 2018-04-25 from <https://tools.ietf.org/html/rfc5234#appendix-B.1>

alpha          :  (CAP_A | CAP_B | CAP_C | CAP_D | CAP_E | CAP_F | CAP_G | CAP_H | CAP_I | CAP_J | CAP_K | CAP_L | CAP_M | CAP_N | CAP_O | CAP_P | CAP_Q | CAP_R | CAP_S | CAP_T | CAP_U | CAP_V | CAP_W | CAP_X | CAP_Y | CAP_Z) | (A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z);   // A-Z / a-z

digit          :  (ZERO | ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN | EIGHT | NINE);
                       // 0-9

hexdig         :  digit | (CAP_A | A) | (CAP_B | B) | (CAP_C | C) | (CAP_D | D) | (CAP_E | E) | (CAP_F | F);

//////////////////////////////////////////////////////////////////////////
// Lexer rules generated for each distinct character in original grammar
// per http://www.unicode.org/charts/PDF/U0000.pdf
//////////////////////////////////////////////////////////////////////////

EXCLAMATION : '!';
POUND : '#';
DOLLAR : '$';
PERCENT : '%';
AMPERSAND : '&';
APOSTROPHE : '\'';
LEFT_PAREN : '(';
RIGHT_PAREN : ')';
ASTERISK : '*';
PLUS : '+';
COMMA : ',';
DASH : '-';
PERIOD : '.';
SLASH : '/';
ZERO : '0';
ONE : '1';
TWO : '2';
THREE : '3';
FOUR : '4';
FIVE : '5';
SIX : '6';
SEVEN : '7';
EIGHT : '8';
NINE : '9';
COLON : ':';
SEMICOLON : ';';
EQUALS : '=';
QUESTION : '?';
AT : '@';
CAP_A : 'A';
CAP_B : 'B';
CAP_C : 'C';
CAP_D : 'D';
CAP_E : 'E';
CAP_F : 'F';
CAP_G : 'G';
CAP_H : 'H';
CAP_I : 'I';
CAP_J : 'J';
CAP_K : 'K';
CAP_L : 'L';
CAP_M : 'M';
CAP_N : 'N';
CAP_O : 'O';
CAP_P : 'P';
CAP_Q : 'Q';
CAP_R : 'R';
CAP_S : 'S';
CAP_T : 'T';
CAP_U : 'U';
CAP_V : 'V';
CAP_W : 'W';
CAP_X : 'X';
CAP_Y : 'Y';
CAP_Z : 'Z';
LEFT_BRACE : '[';
RIGHT_BRACE : ']';
UNDERSCORE : '_';
A : 'a';
B : 'b';
C : 'c';
D : 'd';
E : 'e';
F : 'f';
G : 'g';
H : 'h';
I : 'i';
J : 'j';
K : 'k';
L : 'l';
M : 'm';
N : 'n';
O : 'o';
P : 'p';
Q : 'q';
R : 'r';
S : 's';
T : 't';
U : 'u';
V : 'v';
W : 'w';
X : 'x';
Y : 'y';
Z : 'z';
TILDE : '~';
